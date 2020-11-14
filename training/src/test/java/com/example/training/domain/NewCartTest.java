package com.example.training.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.example.training.enity.Product;

public class NewCartTest {

	@Test
	void create() {
		NewCart cart = new NewCart();
		assertNotNull(cart);
	}

	@Test
	void add() {
		Product product = new Product(1, "ガム");
		NewCart cart = new NewCart();
		cart.add(product);
		assertEquals(1, cart.getSize());
		cart.add(product);
		assertEquals(1, cart.getSize());
	}

	@Test
	void addWithQuantity() {
		Product product = new Product(1, "ガム");
		NewCart cart = new NewCart();
		cart.add(product, 2);
		assertEquals(1, cart.getSize());
	}

	@Test
	void remove() {
		Product product = new Product(1, "ガム");
		NewCart cart = new NewCart();
		cart.add(product);
		assertEquals(1, cart.getSize());
		cart.remove(product);
		assertEquals(1, cart.getSize());
		cart.remove(product);
		assertEquals(1, cart.getSize());

	}

	@Test
	void list() {
		Product product = new Product(1, "ガム");
		Product product2 = new Product(2, "チョコ");
		NewCart cart = new NewCart();
		cart.add(product);
		List<NewCartItem> products = cart.getList();
		assertNotNull(products);
		assertEquals(1, products.size());

		cart.add(product2);
		List<NewCartItem> products2 = cart.getList();
		assertEquals(2, products2.size());

		cart.add(product);
		cart.add(product2, 3);
		Optional<NewCartItem> itemOpt = cart.getItem(product);
		assertTrue(itemOpt.isPresent());

		NewCartItem item = itemOpt.get();
		assertEquals(2, item.getQuantity());
		cart.add(product, 4);
		assertEquals(6, item.getQuantity());// ガムの合計数

		List<NewCartItem> howMatch = cart.getList();
		assertEquals(2, howMatch.size());// itemの種類数
	}

}
