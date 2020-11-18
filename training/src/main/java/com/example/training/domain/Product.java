package com.example.training.enity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
	public Product(int id, String name) {
		this.name = name;
		this.id = id;
	}

	private int id;
	private String name;
	private int price;
	private String description;
	private String image_path;

}

