package in.dev.FileGenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "<center><h1> Welcome To File Generation App <h1><center>";
	}
	
	@GetMapping("/about")
	public String about() {
		return "<center><h1> This is about Page! Under development <h1><center>";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "<center><h1> Reach to Us : <a href="+"www.gmail.com/abcd"+">abcd@gmail.com</a> <h1><center>";
		
	}
}
