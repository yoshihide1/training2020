package com.example.training.repository;

import java.util.List;

import com.example.training.enity.Cart;

public interface CartRepository {

	public List<Cart> findId(int id);
}
