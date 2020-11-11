package com.example.training.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.enity.Product;

@Mapper
public interface ProductRepository {

	public List<Product> findAll();
	
	Optional<Product> findId(int id);

//	@Select("select * from PRODUCT")
//	Optional<Product> findAll();
//
//	@Select("insert into product(category_id, name, price, image_path, description)"
//			+ " values (#{categoryId}, #{name}, #{price}, #{imagePath}, #{description})")
//	Optional<Product> find();
}