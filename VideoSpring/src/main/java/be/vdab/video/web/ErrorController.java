package be.vdab.video.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
	@RequestMapping()
	public String error() {
		return "redirect:/";
	}
}
