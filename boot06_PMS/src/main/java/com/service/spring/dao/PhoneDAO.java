package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

//Persistence Layer
@Repository
public class PhoneDAO {
	public static final String NS = "ns.sql.PhoneMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	
	public int insert(Phone phone)throws Exception {
		return sqlSession.insert(NS+"insert",phone);
	}
	
	public int delete(List<String> list)throws Exception {
		return sqlSession.delete(NS+"delete",list);
	}
	
	public int update(Phone phone)throws Exception {
		return sqlSession.update(NS+"update",phone);
	}
	
	public Phone select(Phone phone)throws Exception {
		return sqlSession.selectOne(NS+"select",phone);
	}
	
	public List<Phone> select()throws Exception {
		return sqlSession.selectList(NS+"select",null);
	}
	
	public UserInfo select(UserInfo user)throws Exception {
		return sqlSession.selectOne(NS+"selectUser",user);
	}
	
}
