package com.example.training.domain;

public class CartItem {
	private Product product;
	private int quantity = 0;

	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;
	}

	public String getProductImage() {
		return product.getImage_path();
	}

	public String getProductName() {
		return product.getName();
	}

	public int getProductPrice() {
		return product.getPrice();
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

	public boolean isEmpty() {
		return this.quantity <= 0;
	}

	public int getTotalAmount() {
		int price = getProductPrice() * getQuantity();
		return price;
	}
}
