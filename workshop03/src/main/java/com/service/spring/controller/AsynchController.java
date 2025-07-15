package com.service.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.model.MemberServiceImpl;

//결과 페이지가 아닌 데이터를 반환하는 컨트롤러
@RestController
public class AsynchController {
	
	@Autowired
	MemberServiceImpl service;
	
	@PostMapping("/idExist")
	public ResponseEntity<?> idExist(String id)throws Exception{
		return ResponseEntity.ok(service.idExist(id));
	}
}
