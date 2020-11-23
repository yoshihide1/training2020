package com.example.training;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.training.domain.Cart;

@Component
public class SessionFilter implements Filter {
	@Autowired
	protected HttpSession session;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init!!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		if (cart == null) {
			System.out.println("カート作成");
			cart = new Cart();
			session.setAttribute(Cart.SESSION_NAME, cart);
		} else {
			System.out.println("作成済み");

		}
		chain.doFilter(request, response);
		System.out.println(cart);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
}
