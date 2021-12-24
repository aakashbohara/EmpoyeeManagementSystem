package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllCOntroller {
	
	
	@GetMapping("/table")
	public String showTemplate() {
		 return "table.html";
	}

}
