package com.example.training.repository;

import java.util.List;

import com.example.training.enity.CartOld2;

public interface CartRepository {

	public List<CartOld2> findId(int id);
}
