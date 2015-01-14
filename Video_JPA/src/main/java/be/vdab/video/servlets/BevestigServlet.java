/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.servlets;


import be.vdab.video.entities.Klant;
import be.vdab.video.services.KlantService;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oleg.Kolokolnikov
 */
@WebServlet(name = "BevestigServlet", urlPatterns = {"/bevestiging.htm"})
public class BevestigServlet extends HttpServlet {

    
private static final long serialVersionUID = 1L;
private static final String VIEW = "WEB-INF/JSP/widgets/bevestigingen.jsp";
private static final String MANDJE = "mandje";
KlantService klantService=new KlantService();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int teReserveren=0;
        HttpSession session = request.getSession(false);
        if (session != null) {
                Set mandje =  (Set) session.getAttribute(MANDJE); 
            if (mandje != null) { 
                
                for (Object nummer : mandje) { 
                    teReserveren++;
                }
               
            }
        }
         request.setAttribute("teReserveren", teReserveren);
        
        try {
            int nummer = Integer.parseInt(request.getParameter("klantNr"));
            Klant klant = klantService.findKlantenByNr(nummer);
            if (klant == null) {
            
                request.setAttribute("fout", "klant niet gevonden");
            } else {
                request.setAttribute("klant", klant);
            }
        } catch (NumberFormatException ex) {
       
            request.setAttribute("fout", "Nummer niet correct");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }

   

}
