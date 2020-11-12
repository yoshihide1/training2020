package com.example.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.training.repository.ProductRepository;

@Controller
public class MainController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public String index(Model model) {
		var products = productRepository.findAll();
		model.addAttribute("products", products);
		// model.addAttribute("message", "Hello");
		return "index";
	}

	@GetMapping("/cart")
	public String cart(Model model) {
		// model.addAttribute("message", "Hello");


		return "cart";
	}

	@GetMapping("/product")
	public String product(Model model) {

		return "product";
	}

	@GetMapping("/address")
	public String address(Model model) {
		model.addAttribute("address", "formModel");
		return "address";
	}

	@GetMapping("/complete")
	public String complete(Model model) {
		return "complete";
	}

}
