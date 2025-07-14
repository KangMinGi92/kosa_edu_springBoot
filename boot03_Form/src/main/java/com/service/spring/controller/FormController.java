package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.service.spring.domain.User;

@Controller
public class FormController {

	//폼에 입력된 값 자동바인딩
	@PostMapping("/form")
	public ModelAndView doForm(User user
			/* HttpServletRequest req */) {
		System.out.println("FormController. doForm call...");
		//1. 폼값 받아서
//			String userId=req.getParameter("userId");
//			String userName=req.getParameter("userName");
//			String userAddr=req.getParameter("userAddr");
		
		//2. pvo생성
//			User user = new User(userId,userName,null,userAddr);
		//3. result.jsp 결과페이지로 네비게이션
		//이때 "info"라는 이름으로 pvo정보를 바인딩...
			return 	new ModelAndView("result","info",user);
	}
	
	@GetMapping("/form2")
	public ModelAndView doForm2(String num) {
		System.out.println("FormController. doForm2 call...");
		return new ModelAndView("result","info",num);
	}
}
