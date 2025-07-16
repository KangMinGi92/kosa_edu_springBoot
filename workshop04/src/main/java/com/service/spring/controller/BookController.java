package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/bookList")
	public ModelAndView getBooks() throws Exception{
		List<Book> list=bookService.getBooks();
		return new ModelAndView("book/bookList","list",list);
	}
	
	@PostMapping("/bookRegister")
	public ModelAndView register(String isbn1,String isbn2,String isbn3,Book book,HttpSession session)	{
		System.out.println("register BookVO before:: "+book);//?
		String isbn= isbn1+"-"+isbn2+"-"+isbn3;
		book.setIsbn(isbn); //book 정보가 완성됨
		String path = "redirect:/Error.jsp";
		String msg ="";
		try {
			bookService.insertBook(book);
			path = "redirect:/result.jsp";
			msg = "도서 등록에 성공하셨습니다.";
		}catch(Exception e){
			msg ="도서 등록에 실패하셨습니다.";
		}
		session.setAttribute("msg", msg);
		return new ModelAndView(path);
	}
	
	@GetMapping("/bookSearch")
    public ModelAndView search(String searchField, String searchText,HttpServletRequest request) throws Exception{ 
		System.out.println(searchField);
		List<Book> list = null;
		String path = "find_fail";
		String msg = "도서 검색중 작업에 문제 발생했습니다.";
		//switch 문으로 조건에 따른 검색
		try {
			switch(searchField) {
				case "TITLE" : 
					list=bookService.searchByTitle(searchText);  break;
				case "PUBLISHER" : 
					list=bookService.searchByPublisher(searchText);  break;
				case "PRICE" : 
					list=bookService.searchByPrice(Integer.parseInt(searchText)); break;
				default: 
					list=bookService.getBooks(); break;
			}
			path = "/book/bookList";
			msg = "검색한 도서 리스트 입니다.";
			//DB갔다가 반환된 데이터만 바인딩의 대상이 아니다.!!!
			request.setAttribute("search",searchField);
			request.setAttribute("text",searchText);
		}catch(Exception e) {
			
		}
		return new ModelAndView(path,"list",list);
	}
	@GetMapping("/bookView")
    public ModelAndView bookview(String isbn)throws Exception{
		String path="";
		String msg="";
		Book book =null;
		try {
			book=bookService.searchByIsbn(isbn);
			msg="isbn으로 책 검색";
			path = "/book/bookView";
		}catch(Exception e) {
			msg="isbn에 해당하는 책이 없습니다.";
		}
		return new ModelAndView(path,"book",book);
	}	
	@GetMapping("/bookAjax")
	@ResponseBody
	public Book bookAjax(String isbn) {
		Book book = null;
		try {
			book=bookService.getIsbn(isbn);
		}catch(Exception e) {
			
		}
		return book;
	}
	
}//





