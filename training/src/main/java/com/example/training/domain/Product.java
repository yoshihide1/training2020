package com.example.training.domain;

import lombok.Data;

@Data
public class Product {

	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Product(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {

	}

	private int id;
	private String name;
	private int price;
	private String description;
	private String image_path;

}
