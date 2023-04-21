package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	@GetMapping("/products") //localhost:8080/hello
	public String getProducts() {
		
		return "products-page"; //there will be hello-page.html
	}
}
