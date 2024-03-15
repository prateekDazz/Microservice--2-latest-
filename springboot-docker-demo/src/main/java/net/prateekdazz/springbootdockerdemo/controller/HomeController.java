package net.prateekdazz.springbootdockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/docker")
	public String dockerDemo()
	{
		return "Docker Demo";
	}

}
