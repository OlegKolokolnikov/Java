/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.servlets;

import be.vdab.video.entities.Film;
import be.vdab.video.entities.Genre;
import be.vdab.video.services.FilmService;
import be.vdab.video.services.GenreService;

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
@WebServlet(name = "VideoDetailServlet", urlPatterns = {"/genredetail.htm"})
public class GenresServlets extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/views/ToonFilmsPerGenre.jsp";
    private final FilmService filmService = new FilmService();
    private final GenreService genreService =new GenreService ();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         List<Genre> genres = genreService.findAll();
         request.setAttribute("genres", genres); 
         
        try {
            int genreNummer = Integer.parseInt(request.getParameter("genreNummer"));
            List<Film> film =  filmService.findFilmByGenre(genreNummer);
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
