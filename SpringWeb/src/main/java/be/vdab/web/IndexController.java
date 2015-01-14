package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.FiliaalService;

@Controller
@RequestMapping("/")
public class IndexController {
	//private final LocaleResolver localeResolver;
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("aantalFilialen", filiaalService.findAantalFilialen());
		return modelAndView;
	}
	private final FiliaalService filiaalService;
	@Autowired
	public IndexController(FiliaalService filiaalService) {
		this.filiaalService = filiaalService;
		//this.localeResolver = localeResolver;
	}
//	@RequestMapping(method = RequestMethod.GET, params = {"locale"}) //(1)
//	public String index(
//	HttpServletRequest request, HttpServletResponse response, //(2)
//	@RequestParam String locale) { //(3)
//	String[] onderdelen=locale.split("_");
//	localeResolver.setLocale(
//	request, response, new Locale(onderdelen[0],onderdelen[1])); //(4)
//	return "redirect:/"; //(5)
//	}
}
