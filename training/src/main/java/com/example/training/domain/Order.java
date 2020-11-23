package com.example.training.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.repository.OrderRepository;

@Service
public class Order {
	public static final String SESSION_NAME = "ORDER";

	@Autowired
	OrderRepository orderRepository;

	public void orderPerson(OrderDetail orderDetail) {
		orderRepository.orderUserSave(orderDetail);
	}

	public void orderItem(Cart cart, int orderId) {
		for (CartItem item : cart.getItems()) {
			orderRepository.orderProductSave(item, orderId);
		}
	}
}
