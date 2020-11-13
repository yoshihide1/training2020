package com.example.training;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		ArrayList<Integer> items = (ArrayList<Integer>) session.getAttribute("cart");
		if (items == null) {
			System.out.println("カート作成");
			items = new ArrayList<Integer>();
			session.setAttribute("cart", items);
		} else {
			System.out.println("作成済み");

		}
		chain.doFilter(request, response);
		System.out.println(items);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
}
