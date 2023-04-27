package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Product;

public interface ICRUDProductService {
	//CRUD
	
	//C-create
	public abstract void addNewProduct(String title, String description, float price, int quantity) throws Exception;
	
	//R-retrieve all
	public abstract ArrayList<Product> getProducts();
	
	//R-retrieve by id
	public abstract Product getProductById(long id) throws Exception;
	
	//U-update
	public abstract void updateById(long id, String title, String description, float price, int quantity) throws Exception;
	
	//D-delete
	public abstract void deleteById(long id) throws Exception;
}
