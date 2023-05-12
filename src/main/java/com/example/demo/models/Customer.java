package com.example.demo.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters")
	@Size(min = 3, max = 30)
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters")
	@Size(min = 3, max = 30)
	private String Surname;
	
	@NotNull
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email")
	@Size(min = 8, max = 130)
	private String email;
	
	@Min(18)
	@Max(120)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer(
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters") @Size(min = 3, max = 30) String name,
			@NotNull @Pattern(regexp = "[A-Z]{1}[a-z\\ ]+", message = "Only latin letters") @Size(min = 3, max = 30) String surname,
			@NotNull @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email") @Size(min = 8, max = 130) String email,
			@Min(18) @Max(120) int age) {
		super();
		this.name = name;
		Surname = surname;
		this.email = email;
		this.age = age;
	}
	
	
}
