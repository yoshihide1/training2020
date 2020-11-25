package com.example.training.domain;

import lombok.Data;

@Data
public class OrderItem {
	private String name;
	private int price;
	private int quantity;

	OrderItem() {

	}

	public OrderItem(CartItem item) {
		this.name = item.getProductName();
		this.price = item.getProductPrice();
		this.quantity = item.getQuantity();
	}

}
