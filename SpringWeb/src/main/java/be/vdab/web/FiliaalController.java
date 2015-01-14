package be.vdab.web;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import be.vdab.entities.Filiaal;
import be.vdab.exceptions.FiliaalHeeftNogWerknemersException;
import be.vdab.exceptions.FiliaalMetDezeNaamBestaatAlException;
import be.vdab.exceptions.FiliaalNietGevondenException;
import be.vdab.rest.FiliaalListREST;
import be.vdab.rest.FiliaalREST;
import be.vdab.services.FiliaalService;

@Controller
@RequestMapping("/filialen") 
public class FiliaalController {
	//private final Logger logger = LoggerFactory.getLogger(FiliaalController.class);
	private final FiliaalService filiaalService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView findAll() {
		return new ModelAndView("filialen/filialen",
		"filialen", filiaalService.findAll()); 
	}
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody FiliaalListREST findAllREST() {
		return new FiliaalListREST(filiaalService.findAll());
	}
	@RequestMapping(value="toevoegen", method = RequestMethod.GET)
	public ModelAndView createForm() {
		return new ModelAndView ("filialen/toevoegen","filiaal",new Filiaal());
	}
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Filiaal filiaal, BindingResult bindingResult) {
		if ( ! bindingResult.hasErrors()) {
			try {
				filiaalService.create(filiaal);
				return "redirect:/";
			} catch (FiliaalMetDezeNaamBestaatAlException ex) {
				bindingResult.rejectValue("naam", "filiaalMetDezeNaamBestaatAl"); 
			}
		}
		return "filialen/toevoegen";
	}
	
	@Autowired 
	public FiliaalController(FiliaalService filiaalService) {
		this.filiaalService = filiaalService;
	}
	@RequestMapping(value="{id}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE) 
	public ModelAndView read(@PathVariable long id) { 
		return new ModelAndView("filialen/filiaal", "filiaal",
		filiaalService.read(id));
	}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView delete(@PathVariable long id) { 
		Filiaal filiaal = filiaalService.read(id);
		if (filiaal == null) {
		return new ModelAndView("redirect:/");
		}
		ModelAndView modelAndView = new ModelAndView();
		try {
		filiaalService.delete(id);
		modelAndView.setViewName("redirect:/filialen/verwijderd");
		modelAndView.addObject("id", id);
		modelAndView.addObject("naam", filiaal.getNaam());
		} catch (FiliaalHeeftNogWerknemersException ex) {
			modelAndView.setViewName("redirect:/filialen/{id}"); 
			modelAndView.addObject(
			"fout", "Filiaal is niet verwijderd, het bevat nog werknemers");
		}
		return modelAndView;
	}
	@RequestMapping(value = "verwijderd", method = RequestMethod.GET, params = {"id", "naam"}) 
	public String deleted() {
			return "filialen/verwijderd";
	}
	@RequestMapping(value = "vantotpostcode", method = RequestMethod.GET)
	public ModelAndView findByPostcodeForm() {
		return new ModelAndView("filialen/vantotpostcode",
				"vanTotPostcodeForm",new VanTotPostcodeForm());
	}
	@InitBinder("vanTotPostcodeForm") 
	public void initBinderVanTotPostcodeForm(DataBinder dataBinder) { 
		dataBinder.initDirectFieldAccess();
	}
	@RequestMapping(method=RequestMethod.GET, params={"vanpostcode","totpostcode"})
	public ModelAndView findByPostcode(@Valid VanTotPostcodeForm vanTotPostcodeForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("filialen/vantotpostcode");
		if ( ! bindingResult.hasErrors() && ! vanTotPostcodeForm.isValid()) {
			bindingResult.reject("fouteVanTotPostcode", new Object[] { 
			vanTotPostcodeForm.getVanpostcode (),
			vanTotPostcodeForm.getTotpostcode() }, "");
		}
		if ( ! bindingResult.hasErrors()) {
			modelAndView.addObject("filialen", filiaalService.findByPostcode(
			vanTotPostcodeForm.getVanpostcode(),vanTotPostcodeForm.getTotpostcode()));
		}
		return modelAndView;
	}
	@InitBinder("filiaal")
	public void initBinderFiliaal(DataBinder dataBinder) { 
		Filiaal filiaal = (Filiaal) dataBinder.getTarget(); 
		if (filiaal.getAdres() == null) { 
			filiaal.setAdres(new AdresForm()); 
		}
		else {
			filiaal.setAdres(new AdresForm(filiaal.getAdres())); 
		}
	}
	@RequestMapping(value = "{id}/wijzigen", method = RequestMethod.GET)
	public ModelAndView updateForm(@PathVariable long id) {
		Filiaal filiaal = filiaalService.read(id);
		if (filiaal == null) {
			return new ModelAndView("redirect:/filialen");
		}
			return new ModelAndView("filialen/wijzigen", "filiaal", filiaal);
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public String update(@PathVariable long id, @Valid Filiaal filiaal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "filialen/wijzigen";
		}
		try {
			filiaalService.update(filiaal);
			return "redirect:/";
		} catch (FiliaalMetDezeNaamBestaatAlException ex) {
			bindingResult.rejectValue("naam", "filiaalMetDezeNaamBestaatAl");
			return "filialen/wijzigen";
		}
	}
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody FiliaalREST readREST(@PathVariable long id) { 
		Filiaal filiaal = filiaalService.read(id);
		if (filiaal == null) {
			throw new FiliaalNietGevondenException();
		}
		return new FiliaalREST(filiaal); 
	}
	@ExceptionHandler(FiliaalNietGevondenException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody String filiaalNietGevonden() { 
		return "filiaal bestaat niet";
	}
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteREST(@PathVariable long id) { 
	Filiaal filiaal = filiaalService.read(id);
	if (filiaal == null) {
		throw new FiliaalNietGevondenException(); 
	}
		filiaalService.delete(id);
	}
	@ExceptionHandler(FiliaalHeeftNogWerknemersException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody String filiaalHeeftNogWerknemers() { 
		return "filiaal heeft nog werknemers";
	}
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createREST(@RequestBody @Valid Filiaal filiaal, HttpServletResponse response) {
		filiaalService.create(filiaal);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/filialen/{id}").buildAndExpand(filiaal.getId()).toUri(); 
				response.setHeader("Location", uri.toString());
	}
	@ExceptionHandler(FiliaalMetDezeNaamBestaatAlException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String filiaalMetDezeNaamBestaatAl() { 
		return "filiaal met deze naam bestaat al";
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody public String filiaalMetVerkeerdeProperties(
	MethodArgumentNotValidException ex) { 
		StringBuffer fouten = new StringBuffer();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) { 
			fouten.append(error.getField()).append(':') 
			.append(error.getDefaultMessage()).append("\n"); 
		}
		fouten.deleteCharAt(fouten.length() - 1); 
		return fouten.toString();
	}
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody void updateREST(@PathVariable long id, @RequestBody @Valid Filiaal filiaal) {
		if (filiaalService.read(id) == null) { 
			throw new FiliaalNietGevondenException(); 
		}
		filiaalService.update(filiaal); 
	}
	@RequestMapping(value = "{id}", method = RequestMethod.OPTIONS)
	public @ResponseBody void filiaalOptions(@PathVariable long id, 
	HttpServletResponse response) { 
		Filiaal filiaal = filiaalService.read(id);
		if (filiaal == null) {
			throw new FiliaalNietGevondenException(); 
		}
		String allow = "GET,PUT"; 
		if (filiaal.getWerknemers().isEmpty()) {
			allow += ",DELETE"; 
		}
		response.setHeader("Allow", allow); 
	}
	
}
