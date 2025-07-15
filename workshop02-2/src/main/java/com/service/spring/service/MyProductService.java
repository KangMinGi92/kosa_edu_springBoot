package com.service.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;

//데이타 가공....SELECT문 / DELETE
@Service
public class MyProductService {

	@Autowired
	private MyProductDAO myProductDAO;
	
//	public void addProduct(MyProduct vo) throws Exception{
//		myProductDAO.addProduct(vo); 
//	}
	
//	public List<MyProduct> findProducts(MyProduct vo)  throws Exception{
//		return myProductDAO.findProducts(vo);
//	}
	public List<MyProduct> findProducts(Map<String,String> map)  throws Exception{
		return myProductDAO.findProducts(map);
	}
}
