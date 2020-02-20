package com.dh.bapro.ejemploabmpeliculas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	// Al entrar al localhost:8080
	@GetMapping
	public String irAlHome() {
		return "home";
	}
}
