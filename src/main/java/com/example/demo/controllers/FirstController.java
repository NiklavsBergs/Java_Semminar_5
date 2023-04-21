package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.models.Product;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class FirstController {
	
	private ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(
			new Product("Opel", "black", 1000.5f, 4),
			new Product("VW", "grey", 3000.5f, 4),
			new Product("Dacia", "white", 2000.5f, 4)));
	
	@GetMapping("/hello") //localhost:8080/hello
	public String getHelloFunc() {
		System.out.println("Sveiki!");
		return "hello-page"; //there will be hello-page.html
	}
	
	@GetMapping("/msg") //localhost:8080/msg
	public String getMsgFunc(Model model) {
		model.addAttribute("packet", "Important message");
		return "msg-page"; //will show msg-page.html
	}
	
	@GetMapping("/one-product")//localhost:8080/one-product
	public String getOneProductFunc(Model model) {
		Product prod = new Product("Apple", "Tasty", 1.2f, 9);
		model.addAttribute("packet", prod);
		return "one-product-page";//will show one-product-page.html
	}

}
