package com.example.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.training.repository.ProductRepository;

@Controller
@RequestMapping("/product")
//@SessionAttributes(value = { "cartItem" })
public class ProductController {

	@Autowired
	private ProductRepository productRepository;


	@GetMapping("detail/{id}")
	public String detail (@PathVariable("id") int id, Model model) {
		var product = productRepository.findId(id).orElseThrow(() -> new IllegalArgumentException());
		model.addAttribute("product", product);
		return "product/detail";
	}
	@GetMapping("/sample")
	public String sample(Model model) {
		System.out.println(111);
		var products = productRepository.findAll();
		model.addAttribute("products", products);
		return "sample";
	}

//	@GetMapping("/list")
//	public String list(Model model) {
//		var products = productRepository.findAll();
//		model.addAttribute("products", products);
//		return "index";
//	}
}
