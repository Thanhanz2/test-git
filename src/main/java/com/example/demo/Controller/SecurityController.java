package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String loginForm(Model md) {
		md.addAttribute("message", "Vui Long dang nhap");
		return "security/login";
	}

	@RequestMapping("/security/login/success")
	public String success(Model md) {
		md.addAttribute("message", "success");
		// return "security/login";
		return "order/checkout";
	}

	@RequestMapping("/security/login/error")
	public String error(Model md) {
		md.addAttribute("message", "Sai thong tin dang nhap");
		return "security/login";
	}

	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model md) {
		md.addAttribute("message", "Khong co quyen truy xuat");
		return "security/login";
	}

	@RequestMapping("/security/logoff/success")
	public String logoff(Model md) {
		md.addAttribute("message", "CÚT");
		return "security/login";
	}
}
