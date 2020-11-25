package com.example.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.training.domain.Cart;
import com.example.training.domain.Order;
import com.example.training.domain.OrderForm;
import com.example.training.domain.OrderItem;
import com.example.training.domain.OrderService;
import com.example.training.repository.OrderRepository;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private HttpSession session;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	@GetMapping("/form")
	public String form(OrderForm orderForm, Model model) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		model.addAttribute("cart", cart);
		model.addAttribute("orderForm", orderForm);
		return "/order/detail";
	}

	/**
	 * 
	 */
	@PostMapping("/save")
	public String save(@ModelAttribute("orderForm") @Valid OrderForm orderForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return form(orderForm, model);
		} else {
			Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
			int orderId = orderService.order(orderForm, cart);
			session.setAttribute(Cart.SESSION_NAME, new Cart());
			return "redirect:/order/complete/" + orderId;
		}
	}

	@GetMapping("/complete/{id}")
	public String complete(@PathVariable int id, Model model) {
		Order order = orderRepository.findById(id);
		List<OrderItem> items = orderRepository.findItemByOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("items", items);
		return "/order/complete";
	}
}
