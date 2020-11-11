package com.example.training;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/index")
	public String index(Model model) {
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
		// model.addAttribute("message", "Hello");
		/*
		 * msgとしてdescriptionを渡す。
		 */
		return "product";
	}

	@GetMapping("/address")
	public String address(Model model) {
		return "address";
	}

	@GetMapping("/complete")
	public String complete(Model model) {
		return "complete";
	}

}
