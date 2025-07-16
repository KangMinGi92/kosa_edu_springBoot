package com.service.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.service.spring.domain.User;

public class UserJunitTest {
	private static final String NS = "ns.sql.UserMapper.";
	private SqlSession getSqlSession()throws Exception{
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		return session;
	}
	
	@Test
	public void login()throws Exception {
		SqlSession session = getSqlSession();
		User user=new User();
		user.setUserId("kosa");
		User result=session.selectOne(NS+"login",user);
		System.out.println(result);
	}
	
	@Test
	public void addUser()throws Exception {
		SqlSession session = getSqlSession();
		User user=new User("test","1234","김코사","kosa@kosa.com");
		System.out.println(session.insert(NS+"addUser",user));
		session.commit();
	}
}
