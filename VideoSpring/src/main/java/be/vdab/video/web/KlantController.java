package be.vdab.video.web;


import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.video.entities.Film;
import be.vdab.video.entities.Klant;
import be.vdab.video.services.KlantService;

@Controller
@RequestMapping("/klanten")
public class KlantController {
	private final KlantService klantService;
	private static final String MANDJE = "mandje";
	@Autowired
	public KlantController(KlantService klantService){
		this.klantService=klantService;
	}
	@RequestMapping(value = "klanten",method=RequestMethod.GET)
	public ModelAndView klantenForm(){
		return new ModelAndView("/widgets/ToonKlanten",
				"klantForm",new KlantForm());
	}
	@InitBinder("klantForm") 
	public void initBinderKlantForm(DataBinder dataBinder) {
		dataBinder.initDirectFieldAccess();
	}
	@RequestMapping(value = "klanten", method=RequestMethod.GET, params={"naam"})
	public ModelAndView findKlantByNaam(@Valid KlantForm klantForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("/widgets/ToonKlanten");
		if ( ! bindingResult.hasErrors()) {
			List<Klant> klant = klantService.findKlantenByName(klantForm.getNaam());
			if(klant.isEmpty())
				modelAndView.addObject("fouten","Niemand gevonden");
			modelAndView.addObject("klant",klant);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/bevestig/{klanten.klantNr}", method=RequestMethod.GET)
	public ModelAndView klantenBevestig(@PathVariable("klanten.klantNr") int klnummer, HttpSession session){
		ModelAndView modelAndView = new ModelAndView("/widgets/bevestigingen");
	        if (session != null) {
	        	@SuppressWarnings("unchecked")
				ConcurrentHashMap<Integer,Film> mandje =  (ConcurrentHashMap<Integer, Film>) session.getAttribute(MANDJE); 
	        	if(mandje != null)
	        	modelAndView.addObject("teReserveren", mandje.size());
	        }
	        Klant klant = klantService.findKlantenByNr(klnummer);
	        modelAndView.addObject("klant", klant);
	return modelAndView;
	}
}
