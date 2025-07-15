package com.service.spring.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.service.spring.domain.Member;

public class MyBatisMemberTestApp {
	
	private static final String NS = "MemberMapper.";
	
	private SqlSession getSqlSession()throws Exception{
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		return session;
	}
	@Test
	public void registerMember()throws Exception{
		SqlSession session = getSqlSession();
		Member member = new Member("kosa","1234","강민기","경기도 안산");
		session.insert(NS+"registerMember",member);
		session.commit();
	}
	
	@Test
	public void deleteMember()throws Exception{
		SqlSession session = getSqlSession();
		session.delete(NS+"deleteMember","kosa");
		session.commit();
	}
	
	@Test
	public void updateMember()throws Exception{
		SqlSession session = getSqlSession();
		Member member = new Member("kosa","1234","코사","혜화동");
		session.update(NS+"updateMember",member);
		session.commit();
	}
	
	@Test
	public void showAllMember()throws Exception{
		SqlSession session = getSqlSession();
		List<Member> list=session.selectList(NS+"showAllMember");
		list.forEach(c->System.out.println(c));
	}
	
	@Test
	public void getMember()throws Exception{
		SqlSession session = getSqlSession();
		Member member=session.selectOne(NS+"getMember","kosa");
		System.out.println(member);
	}
	
	@Test
	public void idExist()throws Exception{
		SqlSession session = getSqlSession();
		int idExist=session.selectOne(NS+"idExist","kosa");
		System.out.println(idExist);
	}
	
	@Test
	public void login()throws Exception{
		SqlSession session = getSqlSession();
		Member member=new Member();
		member.setId("kosa");
		member.setPassword("1234");
		Member result=session.selectOne(NS+"login",member);
		System.out.println(result);
	}
}
