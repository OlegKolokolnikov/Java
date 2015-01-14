/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.servlets;

import be.vdab.video.entities.Film;
import be.vdab.video.services.FilmService;

import java.io.IOException;

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
@WebServlet(name = "filmDetailServlet", urlPatterns = {"/filmdetail.htm"})
public class FilmDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/widgets/FilmDetails.jsp";
    private final FilmService filmService = new FilmService();
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int nummer = Integer.parseInt(request.getParameter("filmNummer"));
            Film film = filmService.findFilmByNr(nummer);
            if (film == null) {
                request.setAttribute("fout", "Film niet gevonden");
            } else {
                request.setAttribute("film", film);
            }
        } catch (NumberFormatException ex) {
       
            request.setAttribute("fout", "Nummer niet correct");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
       
    }
}
