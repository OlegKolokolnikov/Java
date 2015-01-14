/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.video.servlets;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.video.entities.Genre;
import be.vdab.video.services.GenreService;

/**
 *
 * @author Oleg.Kolokolnikov
 */
@WebServlet(name = "indexServlet", urlPatterns = {"/index.htm"})
public class IndexServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final String VIEW = "WEB-INF/JSP/views/Start.jsp";
   private final GenreService genreService = new GenreService();

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Genre> genres = genreService.findAll();
         
        request.setAttribute("genres", genres); 
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }

   
}
