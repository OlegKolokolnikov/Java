/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.servlets;

import be.vdab.video.entities.Film;
import be.vdab.video.entities.Reservatie;
import be.vdab.video.services.FilmService;
import be.vdab.video.services.ReservatieService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "RapportServlet", urlPatterns = {"/rapport.htm"})
public class RapportServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
private static final String VIEW = "WEB-INF/JSP/widgets/rapport.jsp";
private static final String MANDJE = "mandje";
private final FilmService filmService = new FilmService();
private final ReservatieService reservatie=new ReservatieService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int filmnr;
        int gereserveerd;
        int voorraad;
        
        HttpSession session = request.getSession(false);
        if (session != null) {
                Set<Integer> mandje = (Set<Integer>) session.getAttribute(MANDJE);  
            if (mandje != null) { 
                
                int klantnr=Integer.parseInt(request.getParameter("klnummer"));
                List<String> fouten=new ArrayList<String>();
                List<Film> filmInMandje = new ArrayList<Film>();
                mandje.stream().forEach((nummer) -> {
                        filmInMandje.add(filmService.findFilmByNr((int) nummer));
                    });
                for (Film film : filmInMandje) { 
                    filmnr=film.getFilmNr();
                    gereserveerd=film.getGereserveerd();
                    voorraad=film.getVoorraad();
                    if(voorraad>gereserveerd){
                        Reservatie res = new Reservatie(klantnr,filmnr);
                        reservatie.create(res);
                        filmService.reserveerExemplaar(film.getFilmNr());
                        request.setAttribute("reservatie", res);
                        
                    }else
                        fouten.add(film.getTitel());
                }
                
                    request.setAttribute("fouten", fouten);
            }
        }
        
        session.removeAttribute(MANDJE);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
       
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        
  }

}
