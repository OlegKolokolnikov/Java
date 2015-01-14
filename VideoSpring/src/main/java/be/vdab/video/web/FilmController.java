package be.vdab.video.web;



import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.video.entities.Film;
import be.vdab.video.services.FilmService;

@Controller
@RequestMapping("/")

public class FilmController {
	private static final String MANDJE = "mandje";
	private final FilmService filmService;
	
	@Autowired
	public FilmController(FilmService filmService){
		this.filmService=filmService;
	}
	@RequestMapping(value = "filmdetail/{filmNummer}",method=RequestMethod.GET)
	public ModelAndView toonFilmDetail(@PathVariable int filmNummer){
		return new ModelAndView("/widgets/FilmDetails", "film",
				filmService.findFilmByNr(filmNummer));
	}
	@RequestMapping(value="/mandje", method=RequestMethod.GET)
	public ModelAndView getFIlmsFromMandje(HttpSession session){
		ModelAndView modelAndView = new ModelAndView("/views/Mandje");
		@SuppressWarnings("unchecked")
		ConcurrentHashMap<Integer,Film> filmsInMandje= (ConcurrentHashMap<Integer, Film>) session.getAttribute(MANDJE); 
			if (filmsInMandje != null) {
				modelAndView.addObject("filmInMandje", filmsInMandje.values());
			}
	        return modelAndView;
	}
	@RequestMapping(value="/mandje",method=RequestMethod.POST)
	public String PutFilmsInMandje(@RequestParam(value="nummer", required=true) Integer nummer, HttpSession session){
		@SuppressWarnings("unchecked")
		ConcurrentHashMap<Integer,Film> filmsInMandje= (ConcurrentHashMap<Integer, Film>) session.getAttribute(MANDJE); 
            if (filmsInMandje == null) { 
                filmsInMandje = new ConcurrentHashMap<Integer, Film>(); 
            }
            try {
	            filmsInMandje.put(nummer, filmService.findFilmByNr(nummer));
	            session.setAttribute(MANDJE,filmsInMandje); 
            } catch (Exception ex) {
            
            }
		
		return "redirect:/mandje";
	}
	@RequestMapping(value="/mandje/verwijder",method=RequestMethod.POST)
	public String verwijderFIlmVanMandje(@RequestParam(value="verwijdernummer", required=false) Integer[] verwijdernummer, HttpSession session){
		@SuppressWarnings("unchecked")
		ConcurrentHashMap<Integer,Film> filmsInMandje= (ConcurrentHashMap<Integer, Film>) session.getAttribute(MANDJE); 
		if(verwijdernummer != null){
	            if (filmsInMandje == null) { 
	                filmsInMandje = new ConcurrentHashMap<Integer, Film>(); 
	            }
	            try {
	                 for (Integer filmNr : verwijdernummer) {
	                    filmsInMandje.remove(filmNr);
	                 }
	            session.setAttribute(MANDJE,filmsInMandje); 
	            } catch (Exception ex) {
	            
	            }
			}
		return "redirect:/mandje";
	}

}
