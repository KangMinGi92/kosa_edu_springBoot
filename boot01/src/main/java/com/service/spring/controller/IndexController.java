package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String doHello(Model model) {
		System.out.println("IndexController...진입...doHelo() 호출됨...");
		model.addAttribute("message","Hello Boot~~!!");
		return "result";
		
	}
	@GetMapping("/home")
	public ModelAndView getHome() {
		System.out.println("IndexController..진입...getHome() 호출됨...");
		
		return new ModelAndView("result2","info","Home Spring Boot~~!!");
	}
}
