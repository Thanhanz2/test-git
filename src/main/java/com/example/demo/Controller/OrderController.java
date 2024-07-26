package com.example.demo.Controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/order/checkout")
	public String order() {
		return "order/checkout";
	}

	@RequestMapping("/order/list")
	public String list(Model md, HttpServletRequest rp) {
		String username = rp.getRemoteUser();
		md.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}

	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model md) {
		md.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
}
