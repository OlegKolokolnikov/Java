package be.vdab.video.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.video.entities.Film;
import be.vdab.video.entities.Reservatie;
import be.vdab.video.services.FilmService;
import be.vdab.video.services.ReservatieService;
@Controller
@RequestMapping("/rapport")
public class ReservatieController {
	private static final String MANDJE = "mandje";
	private final FilmService filmService;
	private final ReservatieService reservatieService;
	@Autowired
	public ReservatieController(FilmService filmService, ReservatieService reservatieService){
		this.filmService=filmService;
		this.reservatieService=reservatieService;
	}
	@RequestMapping(value="/{klanten.klantNr}", method=RequestMethod.POST)
	public ModelAndView reserveerFilms(@RequestParam(value="klantNummer", required=true) int klantnr, HttpSession session){
		ModelAndView modelAndView = new ModelAndView("/widgets/rapport");
        int filmnr;
        int gereserveerd;
        int voorraad;
        
        if (session != null) {
        	@SuppressWarnings("unchecked")
			ConcurrentHashMap<Integer,Film> filmsInMandje = (ConcurrentHashMap<Integer,Film>) session.getAttribute(MANDJE);  
            if (filmsInMandje != null) { 
                List<String> fouten=new ArrayList<String>();
                for (Film film : filmsInMandje.values()) { 
                    filmnr=film.getFilmNr();
                    Film filmDb=filmService.findFilmByNr(filmnr);
                    gereserveerd=filmDb.getGereserveerd();
                    voorraad=filmDb.getVoorraad();
                    if(voorraad>gereserveerd){
                        Reservatie res = new Reservatie(klantnr,filmnr);
                        reservatieService.create(res);
                        filmService.reserveerExemplaar(film.getFilmNr());
                        
                    }else
                        fouten.add(film.getTitel());
                }
                
                modelAndView.addObject("fouten", fouten);
            }
            session.removeAttribute(MANDJE);
        }
        return modelAndView;
	}
}
