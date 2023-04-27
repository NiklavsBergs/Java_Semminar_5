package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Product;

public interface IFilteringProduct {
	//filter products: price less than
	public ArrayList<Product> priceLessThan(float priceThreshold) throws Exception;
	
	//filter products: quantity less than
	public ArrayList<Product> quantityLessThan(int quantityThreshold) throws Exception;
	
	//filter product: sorting
	public ArrayList<Product> sortByPrice(Sort order);
}
