package com.service.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAO {
	public static final String NS = "ns.sql.MyProductMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public void addProduct(MyProduct vo) throws Exception{
		sqlSession.insert(NS+"addProduct", vo);
	}
	
//	public List<MyProduct> findProducts(MyProduct vo)  throws Exception{
//		return sqlSession.selectList(NS+"findProducts",vo);
//	}
	public List<MyProduct> findProducts(Map<String,String> map)  throws Exception{
	return sqlSession.selectList(NS+"findProducts",map);
	}
}










