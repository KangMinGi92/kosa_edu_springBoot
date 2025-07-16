package com.service.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/memberLogin")
	public ModelAndView login(User user, HttpSession session) throws Exception{
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 잘못되었습니다.";
//		System.out.println("getUser Before :: "+user);// name, email값은 null,null
		User rvo=userService.getUser(user);
//		System.out.println("getUser After :: "+rvo);
		if(rvo != null) {
			session.setAttribute("user", rvo);
			msg=rvo.getName()+"님 환영합니다.";
		}
		session.setAttribute("msg", msg);
		return new ModelAndView("redirect:/index.jsp");
	}
	
	@GetMapping("/memberLogout")
	public ModelAndView logout(HttpSession session) throws Exception{
		if(session.getAttribute("user") !=null) 
			session.invalidate();
		return new ModelAndView("redirect:/index.jsp");
	}

}















