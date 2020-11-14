package com.example.training.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.training.enity.Product;

public class NewCart {
	List<NewCartItem> items = new ArrayList<NewCartItem>();

	public void add(Product product) {
		this.add(product, 1);
	}

	public void add(Product product, int quantity) {
		Optional<NewCartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			itemOpt.get().addQuantity(quantity);
		} else {
			items.add(new NewCartItem(product));
		}

	}

	public Optional<NewCartItem> getItem(Product product) {
		for (NewCartItem item : items) {
			int id = item.getProductId();
			if (id == product.getId()) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

	public void remove(Product product) {
		Optional<NewCartItem> itemOpt = getItem(product);
		if (itemOpt.isPresent()) {
			var item = itemOpt.get();
			item.removeQuantity(1);
		}
	}

	public int getSize() {
		return items.size();
	}

	public List<NewCartItem> getList() {
		return items;
	}

}
