package com.example.training.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {
	private int id;
	private String name;
	private String address;
	private String email;
	private String phone;
	private int price;
	private String date;

	public Order(OrderForm orderForm) {
		this.name = orderForm.getFullName();
		this.address = orderForm.getFullAddress();
		this.email = orderForm.getEmail();
		this.phone = orderForm.getPhone();
		this.date = orderForm.getDate();
	}

	public Order() {
	}

	public List<OrderItem> createItem(Cart cart) {
		List<OrderItem> results = new ArrayList<OrderItem>(cart.getSize());
		for (CartItem item : cart.getItems()) {
			results.add(new OrderItem(item));
		}
		return results;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPrice(Cart cart) {
		int total = 0;
		for (CartItem item : cart.getItems()) {
			total += item.getTotalAmount();
		}
		this.price = total;
	}
}
