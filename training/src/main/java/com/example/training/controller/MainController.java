package com.example.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.training.enity.Address;
import com.example.training.repository.ProductRepository;

@Controller
public class MainController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public String index(Model model) {
		var products = productRepository.findAll();
		model.addAttribute("products", products);
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

	@GetMapping("/order/detail")
	public String address(Model model) {
		model.addAttribute("formModel", new Address());
		return "order/detail";
	}

	@PostMapping("/complete")
	public String complete(
			@ModelAttribute("formModel") Address form,
			Model model) {
		model.addAttribute("form", form);
		return "order/complete";
	}

}
