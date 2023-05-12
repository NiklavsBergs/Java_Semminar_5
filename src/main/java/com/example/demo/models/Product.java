package com.example.demo.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Product {
	@NotNull
	@Pattern(regexp = "[A-Z]{1} [a-z\\ ]+")
	@Size(min = 3, max = 130)
	private String title;
	
	@NotNull
	@Size(min = 5, max = 400)
	@Pattern(regexp = "[A-Z]{1} [a-z0-9A-Z\\ ]+")
	private String description;
	
	@Min(0)
	@Max(10000)
	private float price;
	
	@Min(0)
	@Max(1000000)
	private int quantity;
	
	
	private long id;
	
	private static long idCounter = 1;
	
	public Product(String title, String description, float price, int quantity) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		setId();
	}
	
	public Product() {}
	
	public long getId() {
		return id;
	}
	public void setId() {
		this.id = idCounter++;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", description=" + description + ", price=" + price + ", quantity="
				+ quantity + ", id=" + id + "]";
	}
	
	
}
