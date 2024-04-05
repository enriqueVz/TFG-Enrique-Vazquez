package airsoftspain.proyect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/,/home,/index"})
	public String verHome() {
		return "index";
	}
}
