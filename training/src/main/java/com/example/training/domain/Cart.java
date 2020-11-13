package com.example.training.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.training.enity.Product;

public class Cart {
	private List<CartItem> items = new ArrayList<CartItem>();

	/**
	 * 商品をカートに追加する
	 * 
	 * @param item 商品
	 */
	public void add(Product product) {
		this.add(product, 1);
	}

	/**
	 * 商品をカートに追加する
	 * 
	 * @param item     商品
	 * @param quantity
	 */
	public void add(Product product, int quantity) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			itemOpt.get().addQuantity(quantity);
		} else {
			items.add(new CartItem(product));
		}
	}

	/**
	 * 商品をカートから削除する
	 * 
	 * @param product
	 */
	public void remove(Product product) {
		Optional<CartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			var item = itemOpt.get();
			item.removeQuantity(1);
			if (item.isEmpty()) {
				this.items.remove(item);
			}
		}
	}

	public int getSize() {
		return items.size();
	}

	public List<CartItem> getList() {
		return items;
	}

	public Optional<CartItem> getItem(Product product) {
		for (CartItem item : items) {
			int id = item.getProductId();
			if (id == product.getId()) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

}
