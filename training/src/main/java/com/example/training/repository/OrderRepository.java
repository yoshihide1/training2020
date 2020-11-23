package com.example.training.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.domain.CartItem;
import com.example.training.domain.OrderDetail;

@Mapper
public interface OrderRepository {

	void orderUserSave(OrderDetail orderDetail);

	void orderProductSave(@Param("item") CartItem item, int orderId);

}
