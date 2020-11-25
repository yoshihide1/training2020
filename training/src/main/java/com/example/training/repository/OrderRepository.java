package com.example.training.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.domain.Order;
import com.example.training.domain.OrderItem;

@Mapper
public interface OrderRepository {

	int save(Order order);

	void saveItem(@Param("item") OrderItem item, int id);

	Order findById(int id);

	List<OrderItem> findItemByOrder(Order order);
}
