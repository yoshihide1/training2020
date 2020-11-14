package com.example.training.domain;

import com.example.training.enity.Product;

public class NewCartItem {
	private Product product;
	private int quantity = 0;

	public NewCartItem(Product product) {
		this.product = product;
		this.quantity = 1;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getProductId() {
		return product.getId();
	}

	public void addQuantity(int quantity) {
		this.quantity = this.quantity + quantity;
	}

	public void removeQuantity(int quantity) {
		this.quantity = this.quantity - quantity;

	}

}
