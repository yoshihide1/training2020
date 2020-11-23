package com.example.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.training.domain.Cart;
import com.example.training.domain.Product;
import com.example.training.repository.ProductRepository;

/**
 * @author tsukamoto
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	protected HttpSession session;

	@Autowired
	private ProductRepository productRepository;

	/**
	 * @param id
	 * @return カートに商品の追加
	 */
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable int id) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.add(product);
		return "redirect:/";
	}

	/**
	 * @param id
	 * @return カート内の商品の削除 //
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable int id) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.remove(product);
		return "redirect:/cart/list";
	}

	/**
	 * 商品一覧画面の表示
	 * 
	 */
	@RequestMapping(value = "/list")
	public String doGet(Model model) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		model.addAttribute("cart", cart);
		return "cart";
	}

	@RequestMapping(value = "/clear")
	public String clear() {
		session.removeAttribute(Cart.SESSION_NAME);
		return "redirect:/cart";
	}

}
