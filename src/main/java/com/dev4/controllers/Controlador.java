package com.dev4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controlador {
	
	@GetMapping()
	public String helloWorld() {
		return "Hello World!";
	}
}
