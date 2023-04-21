package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/all-products")//localhost:8080/one-product
	public String getAllProductFunc(Model model) {
		model.addAttribute("packet", allProducts);
		return "all-products-page";//will show all-products-page.html
	}
	
	@GetMapping("/all-products-find")//localhost:8080/one-product
	public String findProducts (@RequestParam("id") long id, Model model) {
		if(id>0) {
			for(Product temp : allProducts) {
				if(temp.getId() == id) {
					model.addAttribute("packet", temp);
					return "one-product-page";
				}
			}
		}
		
		model.addAttribute("packetError", "Wrong ID");
		return "error-page";//will show error-page.html
	}
	
	@GetMapping("/all-products/{id}")//localhost:8080/one-product
	public String findProductsById (@PathVariable("id") long id, Model model) {
		if(id>0) {
			for(Product temp : allProducts) {
				if(temp.getId() == id) {
					model.addAttribute("packet", temp);
					return "one-product-page";
				}
			}
		}
		
		model.addAttribute("packetError", "Wrong ID");
		return "error-page";//will show error-page.html
	}

	@GetMapping("/add-product")
	public String getAddProductFunc(Model model) {
		model.addAttribute("product", new Product());
		return "add-product-page";
	}
	
	@PostMapping("/add-product")
	public String postAddProductFunc(Product product) {
		Product newProduct = new Product(product.getTitle(), product.getDescription(), product.getPrice(), product.getQuantity());
		allProducts.add(newProduct);
		return "redirect:/all-products";
	}
	
	@GetMapping("/edit-product/{id}")
	public String editProductsById (@PathVariable("id") long id, Model model) {
		if(id>0) {
			for(Product temp : allProducts) {
				if(temp.getId() == id) {
					model.addAttribute("product", temp);
					return "edit-product-page";
				}
			}
		}
		
		model.addAttribute("packetError", "Wrong ID");
		return "error-page";//will show error-page.html
	}
	
	@PostMapping("/edit-product/{id}")
	public String postEditProductFunc(@PathVariable("id") long id, Product product) {
		for(Product temp : allProducts) {
			if(temp.getId() == id) {
				temp.setTitle(product.getTitle());
				temp.setDescription(product.getDescription());
				temp.setPrice(product.getPrice());
				temp.setQuantity(product.getQuantity());
				return "redirect:/all-products/" + id;
			}
		}
		return "redirect:/error";
	}
	
	@GetMapping("/error")
	public String getErrorFunc(Model model) {
		model.addAttribute("packetError", "Wrong id");
		return "error-page";
	}
}
