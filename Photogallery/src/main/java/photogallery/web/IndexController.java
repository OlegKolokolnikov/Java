package photogallery.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/")

public class IndexController {
//	@Autowired
//	public IndexController(){
//		
//	}
	private int[] image={1,2,3,4,5,6};	
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView index() {
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("image", image);
			
			return modelAndView;
		}
		
		@RequestMapping(value="test", method=RequestMethod.GET)
		public ModelAndView test() {
			ModelAndView modelAndView = new ModelAndView("test");
			return modelAndView;
		}
		
	
}
