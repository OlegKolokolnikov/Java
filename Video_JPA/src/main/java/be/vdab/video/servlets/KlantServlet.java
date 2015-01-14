/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.servlets;

import be.vdab.video.entities.Klant;
import be.vdab.video.services.KlantService;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oleg.Kolokolnikov
 */
@WebServlet(name = "KlantServlet", urlPatterns = {"/klant.htm"})
public class KlantServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
private static final String VIEW = "WEB-INF/JSP/widgets/ToonKlanten.jsp";
KlantService klantService=new KlantService();   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fouten=null;
        try {
            String naam=request.getParameter("naam");
            
            if (naam != null) {
                if(naam.isEmpty()){
                fouten="Tik minstens één letter";
                }else{
                    List<Klant> klant = klantService.findKlantenByName(naam); 
                    if (klant.isEmpty()) {
                        fouten="niemand gevonden";
                    }
                    if (klant == null) {
                        request.setAttribute("fout", "Klanten niet gevonden");
                    } else {
                        request.setAttribute("klant", klant);
                    }
                }
                request.setAttribute("fouten",fouten);
            }
            
        } catch (NumberFormatException ex) {
            request.setAttribute("fout", "Nummer niet correct");
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
        
    }
}
