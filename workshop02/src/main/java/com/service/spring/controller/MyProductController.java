package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

@Controller
public class MyProductController {
	
	@Autowired
	MyProductService myProductService;
	
	@Autowired
	MyProductDAO myProductDao;
	
	//아랫부분에서 요청을 받아서 처리하는 메소드 기능을 정의
	@PostMapping("/insertProduct")
	public ModelAndView addProdect(MyProduct pvo)throws Exception{
		System.out.println("MyProductController...addProdect call....");
		myProductDao.addProduct(pvo);
		//결과페이지 forward, pvo바인딩
		return new ModelAndView("insert_result","vo",pvo);
	}
	
	@PostMapping("/findProduct")
	public ModelAndView findProduct(String command, String word)throws Exception{
		List<MyProduct> products=null;
		if(command.equals("findProducts")) {
			products=myProductService.findProducts();
		}else if(command.equals("findProductByName")) {
			products=myProductService.findProductByName(word);
		}else if(command.equals("findProductByMaker")) {
			products=myProductService.findProductByMaker(word);
		}
		//결과페이지로 forward, list를 바인딩 == new ModelAndView(o,o,o,)
		return new ModelAndView("find_result","products",products);
	}
}
