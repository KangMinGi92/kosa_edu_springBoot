package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.spring.domain.Member;
import com.service.spring.model.MemberServiceImpl;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {

	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	//index페이지를 요청해서 응답받도록
	@GetMapping("/")
	public String doIndex() {
		return "redirect:index.jsp";
	}
	
	
	@PostMapping("/register")
	public String registerMember(Member member)throws Exception{
		memberServiceImpl.registerMember(member);
			return "redirect:showAll";

	}
	
	public String deleteMember(String id)throws Exception{
		memberServiceImpl.deleteMember(id);
		return "redirect:index.jsp";

	}
	
	@PostMapping("/update")
	public String updateMember(Member member,HttpSession session)throws Exception{
		memberServiceImpl.updateMember(member);
		//로그인된 상태에서만 수정이 가능...
		if(session.getAttribute("vo") !=null) {
			session.setAttribute("vo", member);
			return "update_result";
		}
		return null;
	}
	@GetMapping("/showAll")
	public String showAllMember(Model model)throws Exception{
		List<Member> list=memberServiceImpl.showAllMember();
		model.addAttribute("list",list);
		return "allView";
	}
	@PostMapping("/find")
	public String getMember(String id, Model model)throws Exception{
		Member rvo=memberServiceImpl.getMember(id);
		String path="error/error.jsp";
		if(rvo != null) {
			model.addAttribute("vo",rvo);
			model.addAttribute("message","회원 발견 - 성공");
			path = "find_ok";
		}else {
			model.addAttribute("message","회원 발견 - 실패");
		}
		return path;
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session)throws Exception{
		Member rvo= memberServiceImpl.login(member);
		session.setAttribute("vo", rvo);
		if(rvo != null)
			return "login_result";
		else
			return "redirect:login.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)throws Exception {
		if(session.getAttribute("vo") != null) {//로그인된 상태라면은
			session.invalidate();
			return "logout";
		}
		return null;
	}
	
//	@PostMapping("/idExist")
//	@ResponseBody
//	public String idExist(String id)throws Exception{
//		String userId = memberServiceImpl.idExist(id);
//		return userId;
//	}
	
	
}
