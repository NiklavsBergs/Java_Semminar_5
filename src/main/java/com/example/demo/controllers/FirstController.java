package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Product;
import com.example.demo.services.ICRUDProductService;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class FirstController {
	
	@Autowired
	private ICRUDProductService CRUDservice;
	
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
	
	@GetMapping("/all-products")//localhost:8080/one-product
	public String getAllProductFunc(Model model) {
		model.addAttribute("packet", CRUDservice.getProducts());
		return "all-products-page";//will show all-products-page.html
	}
	
	@GetMapping("/all-products-find")//localhost:8080/one-product
	public String findProducts (@RequestParam("id") long id, Model model) {
		try{
			Product prod = CRUDservice.getProductById(id);
			model.addAttribute("packet", prod);
			return "one-product-page";
		}
		catch(Exception e){
			model.addAttribute("packetError", "Wrong ID");
			return "error-page";//will show error-page.html
		}
	}
	
	@GetMapping("/all-products/{id}")//localhost:8080/one-product
	public String findProductsById (@PathVariable("id") long id, Model model) {
		try{
			Product prod = CRUDservice.getProductById(id);
			model.addAttribute("packet", prod);
			return "one-product-page";
		}
		catch(Exception e){
			model.addAttribute("packetError", "Wrong ID");
			e.printStackTrace();
			return "error-page";//will show error-page.html
		}
	}

	@GetMapping("/add-product")
	public String getAddProductFunc(Model model) {
		model.addAttribute("product", new Product());
		return "add-product-page";
	}
	
	@PostMapping("/add-product")
	public String postAddProductFunc(@Valid Product product, BindingResult result) {
		if(!result.hasErrors()) {
			try {
				CRUDservice.addNewProduct(product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity());
				return "redirect:/all-products";
			}
			catch(Exception e) {
				e.printStackTrace();
				return "error-page";//will show error-page.html
			}
		}
		else {
			return "add-product-page";
		}
	}
	
	@GetMapping("/edit-product/{id}")
	public String editProductsById (@PathVariable("id") long id, Model model) {
		try {
			Product prod = CRUDservice.getProductById(id);
			model.addAttribute("product", prod);
			return "edit-product-page";
		}
		catch(Exception e){
			model.addAttribute("packetError", e.getMessage());
			return "error-page";//will show error-page.html
		}
		
		
	}
	
	@PostMapping("/edit-product/{id}")
	public String postEditProductFunc(@PathVariable("id") long id, Product product){
		
		try {
			CRUDservice.updateById(id, product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity());
			return "redirect:/all-products/" + id;
		}
		catch(Exception e){
			e.printStackTrace();
			return "redirect:/error";
		}
		
	}
	
	@GetMapping("/error")
	public String getErrorFunc(Model model) {
		model.addAttribute("packetError", "Wrong id");
		return "error-page";
	}
	
	@GetMapping("/delete-product/{id}")
	public String getDeleteProductFunc(@PathVariable("id") long id, Model model){
		
		try {
		CRUDservice.deleteById(id);
		model.addAttribute("packet", CRUDservice.getProducts());
		return "/all-products-page";
		}
		catch(Exception e) {
			model.addAttribute("packetError", e.getMessage());
			e.printStackTrace();
			return "error-page";//will show error-page.html
		}
	}
}
