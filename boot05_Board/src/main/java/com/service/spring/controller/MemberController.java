package com.service.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.spring.domain.Member;
import com.service.spring.service.MemberService;

import jakarta.servlet.http.HttpSession;

//Presentation Layer Component
@Controller //결과로 데이터를 담고있는 jsp page를 리턴한다.
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/login")
	public String doLogin(Member pvo, HttpSession session, Model model) {
//		String path="Error";
		String path="member/login_result";
		try {
			//정상메세지와 정상결과페이지
			Member rvo = memberService.selectUser(pvo);
			if(rvo !=null) {
				session.setAttribute("mvo", rvo);
//				path="member/login_result";
				model.addAttribute("message", "로그인 작업 - 성공");
			}
		}catch(Exception e) {
			//오류메세지와 에러페이지
			model.addAttribute("message", "로그인 작업 - 에러발생");
		}
		return path;
	}
	
	@GetMapping("/logout")
	public String doLogOut(HttpSession session) {
		Member mvo=(Member)session.getAttribute("mvo");
		if(mvo !=null ) session.invalidate();
		return "redirect:/index.jsp";
	}
}
