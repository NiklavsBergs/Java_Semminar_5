package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.services.ICRUDProductService;

@Service
public class CRUDproductServiceImpl implements ICRUDProductService {

	
	private ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(
			new Product("Opel", "black", 1000.5f, 4),
			new Product("VW", "grey", 3000.5f, 4),
			new Product("Dacia", "white", 2000.5f, 4)));
	
	@Override
	public void addNewProduct(String title, String description, float price, int quantity) throws Exception {
		//TODO verify title and desc with regex
		if(title!=null && description!=null && price>0 && price < 10000 && quantity>0 && quantity<100000) {
			boolean isFound = false;
			for(Product product : allProducts) {
				if(product.getTitle().equals(title) && product.getDescription().equals(description) && product.getPrice()==price) {
					product.setQuantity(product.getQuantity() + quantity);
					isFound = true;
					break;
				}
			}
			if(!isFound) {
				Product newProduct = new Product(title, description, price, quantity);
				allProducts.add(newProduct);
				
			}
		}
		else {
			throw new Exception("Incorrect parameters");
		}
		
	}

	@Override
	public ArrayList<Product> getProducts() {
		return allProducts;
	}

	@Override
	public Product getProductById(long id) throws Exception {
		if(id>0) {
			for(Product product : allProducts) {
				if(product.getId()==id) {
					return product;
				}
			}
			throw new Exception("Product with this id not found");
		}
		else {
			throw new Exception("Incorrect id");
		}
	}

	@Override
	public void updateById(long id, String title, String description, float price, int quantity) throws Exception {
		if(id>0) {
			boolean isFound = false;
			for(Product product : allProducts) {
				if(product.getId()==id) {
					product.setTitle(title);
					product.setDescription(description);
					product.setPrice(price);
					product.setQuantity(quantity);
					isFound = true;
				}
			}
			if(!isFound) {
				throw new Exception("Product with this id not found");	
			}
		}
		else {
			throw new Exception("Incorrect id");
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Product deletedProduct = getProductById(id);
		allProducts.remove(deletedProduct);
		
	}
	
}
