package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/index") // index라는 요청이 들어왔다면
	public ModelAndView doIndex() { //doIndex 함수가 동작해서 요청을 처리할 것이다.
		System.out.println("MainController...doIndex calling...");
		return new ModelAndView("result","info","MainController..POJO Controller");
		//ModelAndView("결과페이지" 확장자는 application.properties에있음,"Attribute Binding key 값","Binding된 value값")
	}
}
