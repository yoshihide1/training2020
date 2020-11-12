package com.example.training.enity;

import lombok.Data;

@Data
public class Product {
	private int id;
	private String name;
	private int price;
	private String image_path;
	private String description;

}
