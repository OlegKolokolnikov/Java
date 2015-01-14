/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.servlets;

import be.vdab.video.entities.Film;
import be.vdab.video.services.FilmService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
@WebServlet(name = "mandjeServlet", urlPatterns = {"/mandje.htm"})
public class MandjeServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final String VIEW = "WEB-INF/JSP/views/Mandje.jsp";
private static final String REDIRECT_URL = "/mandje.htm";    
private static final String MANDJE = "mandje";
private final FilmService filmService = new FilmService();  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession(false);
        if (session != null) {
                Set mandje =  (Set) session.getAttribute(MANDJE); 
            if (mandje != null) { 
                List<Film> filmInMandje = new ArrayList<Film>();
                mandje.stream().forEach((nummer) -> {
                        filmInMandje.add(filmService.findFilmByNr((int) nummer));
                    });
                request.setAttribute("filmInMandje", filmInMandje);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         
         if (request.getParameterValues("nummer") != null) {
            HttpSession session = request.getSession(); 
            Set<Integer> filmNrsInMandje=(Set<Integer>)session.getAttribute(MANDJE); 
            if (filmNrsInMandje == null) { 
                filmNrsInMandje = new LinkedHashSet<Integer>(); 
            }
            try {
                if(request.getParameterValues("verwijdernummer") != null){
                    for (String filmNrAlsString : request.getParameterValues("verwijdernummer")) {
                    filmNrsInMandje.remove(Integer.parseInt(filmNrAlsString)); 
                }
                }
                for (String filmNrAlsString : request.getParameterValues("nummer")) {
                    filmNrsInMandje.add(Integer.parseInt(filmNrAlsString)); 
                }
                session.setAttribute(MANDJE, filmNrsInMandje); 
            } catch (Exception ex) {
            
            }
        }
         
        response.sendRedirect(response.encodeRedirectURL(
        request.getContextPath() + REDIRECT_URL));
    }

}
