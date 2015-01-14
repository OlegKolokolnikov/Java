package be.vdab.video.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.video.services.FilmService;
import be.vdab.video.services.GenreService;

@Controller
@RequestMapping("/")
public class GenreController {

	private final GenreService genreService;
	private final FilmService filmService;
	@Autowired
	public GenreController(GenreService genreService, FilmService filmService) {
		this.genreService = genreService;
		this.filmService=filmService;
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index", "genres", genreService.findAll());
	}
	@RequestMapping(value = "genredetail/{genreNummer}",method=RequestMethod.GET)
	public ModelAndView toonFilmsPerGenre(@PathVariable int genreNummer){
		ModelAndView modelAndView = new ModelAndView("/views/ToonFilmsPerGenre");
		modelAndView.addObject("genres", genreService.findAll());
		modelAndView.addObject("film", filmService.findFilmByGenre(genreNummer));
		return modelAndView;
	}
	
}
