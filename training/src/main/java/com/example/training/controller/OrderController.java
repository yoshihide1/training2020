package com.example.training.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.training.domain.Cart;
import com.example.training.domain.Order;
import com.example.training.domain.OrderDetail;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private Order order = new Order();
	@Autowired
	public HttpSession session;

	@GetMapping("/detail")
	public String detail(OrderDetail orderDetail, Model model) {
		return "/order/detail";
	}

	/**
	 * 入力フォームのバリデーション
	 */
	@PostMapping("/detail")
	public String inputCheck(@ModelAttribute("orderDetail") @Valid OrderDetail orderDetail, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return detail(orderDetail, model);
		} else {
			session.setAttribute(Order.SESSION_NAME, orderDetail);
			order.orderPerson(orderDetail);
			return "redirect:/order/complete";
		}
	}

	@GetMapping("/complete")
	public String complete(Model model) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		OrderDetail orderUser = (OrderDetail) session.getAttribute(Order.SESSION_NAME);
		order.orderItem(cart, orderUser.getId());
		model.addAttribute("orderDetail", orderUser);
		model.addAttribute("cart", cart);
		return "/order/complete";
	}
}
