package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingController {

	@RequestMapping("/cart/view")
	public String cart() {
		return "cart/view";
	}
	
}
