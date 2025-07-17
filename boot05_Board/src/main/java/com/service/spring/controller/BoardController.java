package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

import jakarta.servlet.http.HttpSession;

//Presentation Layer Component
@Controller //결과로 데이터를 담고있는 jsp page를 리턴한다.
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/write")
	public String write(Board pvo,HttpSession session,Model model) {
		Member rvo = (Member)session.getAttribute("mvo");
		if(rvo==null) return "redirect:index.jsp";
		try {
			pvo.setMember(rvo); //board + member
			boardService.write(pvo);
			model.addAttribute("bvo",pvo); 
			return "board/show_content";
		}catch(Exception e) {
			model.addAttribute("message", "Spring Board - 게시글 작성중 에러발생");
			return "Error";
		}
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		try {
			List<Board> list=boardService.getBoardList();
			model.addAttribute("list", list);
			return "/board/list";
		}catch(Exception e) {
			model.addAttribute("message", "Spring Board - 게시글 검색중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("/delete")
	public String doDelete(int no, Model model) {
		try {
			boardService.deleteBoard(no);
			return "redirect:/list";
		}catch(Exception e) {
			model.addAttribute("message","Spring Board  - 게시판 삭제중 에러 발생");
			return "Error";
		}
	}
	@GetMapping("/updateForm")
	public String updateView(int no, Model model) {
		try {
			//service의 showContent(no)를 호출...bvo를 하나반환 받고
			Board bvo=boardService.showContent(no);
			//bvo바인딩
			model.addAttribute("bvo",bvo); 
			//결과 페이지를 update... 여기서 하나의 bvo 내용을 폼에 띄운채로 수정을 진행
			return "/board/update";
		}catch(Exception e) {
			model.addAttribute("message","Spring Board  - 게시판 수정중 에러 발생");
			return "Error";
		}
	}
	
	@PostMapping("/updateBoard")
	public String doUpdate(Board pvo, Model model) {
		try {
			//서비스의 update함수를 호출...
				boardService.updateBoard(pvo);
				//서비스의 showContent 함수를 호출
				Board bvo=boardService.showContent(pvo.getNo());
				model.addAttribute("bvo",bvo);
				return "board/show_content";
			//결과페이지는 show_content.jsp
		}catch(Exception e) {
			model.addAttribute("message","Spring Board  - 게시판 수정중 에러 발생");
			return "Error";
		}
	}
	
	@GetMapping("/showContent")
	public String showDetail(int no, Model model,HttpSession session) {
		Member rvo = (Member)session.getAttribute("mvo");
		if(rvo==null) return "redirect:index.jsp";
		try {
			Board bvo=boardService.showContent(no);
			  if (!rvo.getId().equals(bvo.getMember().getId())) {
		            boardService.updateCount(no); // 작성자가 아닌 경우만 증가
		            bvo.setCount(bvo.getCount() + 1); // 로컬 객체에도 반영 (옵션)
		        }
			model.addAttribute("bvo",bvo);
			return "board/show_content";
		}catch(Exception e) {
			model.addAttribute("message","Spring Board  - 게시판 상세보기중 에러 발생");
			return "Error";
		}
	}
	
}//
