package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.service.PhoneService;

import jakarta.servlet.http.HttpSession;

//Presentation Layer...
//결과페이지를 응답하는 컨트롤러...SSR... jsp사용... 검색이용이... Search Engine Optimizer(SEO)

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	//인트로 페이지부터 요청
	@GetMapping("/") //http://localhost:9000/
	public String home() {
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/regPhone") //핸드폰 등록폼
	public String getRegPhone(Model model) {
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 등록 폼");
		return "PhoneReg";
	}
	
	@PostMapping("/savePhone")
	public String doRegPhone(Phone phone, Model model) {
		try {
			phoneService.insert(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 성공");
			return "Result";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 에러");
			return "Error";
		}
	}
	
	@GetMapping("/searchPhone")
	public String doList(Model model) {
		try {
		List<Phone> phones=phoneService.select();
		model.addAttribute("phones", phones);
		model.addAttribute("title", "핸드폰 관리 - 핸드폰 목록리스트");
		return "PhoneList";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 핸드폰 목록 조회 중 에러발생");
			return "Error";
		}
	}
	
	@GetMapping("/detail")
	public String doDetail(Phone phone,Model model) {
		try {
			Phone selected = phoneService.select(phone);
			model.addAttribute("phone", selected);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세 조회");
			return "PhoneView";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 핸드폰 상세조회 중 에러발생");
			return "Error";
		}
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String doLogin(UserInfo user, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		try {
			UserInfo rvo=phoneService.select(user);
			if(rvo !=null) {//로그인 성공했다면
				session.setAttribute("loginUser", rvo);
				model.addAttribute("title", "유저 관리 -  유저 로그인 성공");
				return "redirect:/searchPhone";
			}else {//로그인 성공 못했다면
				redirectAttributes.addFlashAttribute("title", "유저 관리 -  유저 로그인 실패");
	            redirectAttributes.addFlashAttribute("errorMessage", "아이디 또는 비밀번호를 확인해 주세요.");
				return "redirect:/login";
			}
		}catch(Exception e) {
			model.addAttribute("title", "유저 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 유저 로그인 중 에러발생");
			return "Error";
		}
	}
	
	@PostMapping("/deleteAjax")
	@ResponseBody
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		System.out.println(num);
		try {
			phoneService.delete(num);
			return "";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "문제 내용 - 핸드폰 삭제 중 에러발생");
			return "Error";
		}
	}
}
