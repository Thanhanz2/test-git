package com.example.demo.Controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@Controller
public class ProcductController {

	@Autowired
	ProductService service;

	@RequestMapping("/product/list")
	public String list(Model md, @RequestParam("cid") Optional<String> cid) {
		if (cid.isPresent()) {
			List<Product> list = service.findByCategoryId(cid.get());
			md.addAttribute("items", list);

		} else {
			List<Product> list = service.finAll();
			md.addAttribute("items", list);
		}
		return "/product/list";
	}

	@RequestMapping("/product/detail/{id}")
	public String detail(Model md, @PathVariable("id") Integer id) {
		Product item = service.finById(id);
		md.addAttribute("item", item);
		return "/product/detail";
	}
}
