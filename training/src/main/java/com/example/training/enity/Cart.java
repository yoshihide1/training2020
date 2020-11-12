package com.example.training.enity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int price;
	private String description;
	private String image_path;
}
