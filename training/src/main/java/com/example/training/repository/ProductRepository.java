package com.example.training.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.enity.Product;

@Mapper
public interface ProductRepository {

	public List<Product> findAll();
}