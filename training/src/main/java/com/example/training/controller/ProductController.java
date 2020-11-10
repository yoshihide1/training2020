package com.example.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.training.repository.ProductRepository;

@Controller
@RequestMapping("product")
//@SessionAttributes(value = { "cartItem" })
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/list")
	public String list(Model model) {
		var products = productRepository.findAll();
		model.addAttribute("products", products);
		return "home";
	}
}
