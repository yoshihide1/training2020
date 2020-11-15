package com.example.training.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		var items = (ArrayList<Integer>) session.getAttribute("cart");

		items.add(0, id);
		session.setAttribute("cart", items);
		return "redirect:/";
	}

	/**
	 * @param id
	 * @return カート内の商品の削除 //
	 */
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//	public String delete(@PathVariable int id) {
//
//	}

	/**
	 * 商品一覧画面の表示
	 * 
	 */
	@RequestMapping(value = "/list")
	public String doGet(Model model) {
		var id = (int[]) session.getAttribute("cart");
		var items = productRepository.findIdList(id);
		model.addAttribute("cart", items);
//		}
//		System.out.println("session:" + list);
		return "cart";
	}

	@RequestMapping(value = "/clear")
	public String clear() {
		session.removeAttribute("cart");
		return "redirect:/cart";
	}

}
