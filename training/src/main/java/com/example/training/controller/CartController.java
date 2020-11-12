package com.example.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	protected HttpSession session;

//	@Autowired
//	private CartRepository cartRepository;

	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable int id) {
		session.setAttribute("cart", id);
		return "redirect:/";
	}

	@RequestMapping(value = "/list")
	public String doGet(Model model) {
		if (session.getAttribute("cart") == null) {
			session.setAttribute("message", "カートは空です");
		} else {
			session.removeAttribute("message");
			int id = (int) session.getAttribute("cart");
//			var items = cartRepository.findId(id);
//			model.addAttribute("items", items);
		}
//		System.out.println("session:" + list);
		return "cart";
	}

	@RequestMapping(value = "/clear")
	public String clear() {
		session.removeAttribute("cart");
		return "redirect:/cart";
	}

}
