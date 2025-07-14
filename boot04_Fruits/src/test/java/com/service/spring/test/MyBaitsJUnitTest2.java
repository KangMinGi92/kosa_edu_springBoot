package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.service.spring.domain.Item;

public class MyBaitsJUnitTest2 {
	private static final String NS ="ns.sql.FruitMapper.";
	
	@Test
	public void unit1() throws Exception {
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		Item item = new Item();
		
		List<Item> list=session.selectList(NS+"getItemList", item);
		list.forEach(c->System.out.println("getItemList => "+c));
		
		
	}
	
	@Test
	public void unit2() throws Exception{
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		Item result = session.selectOne(NS+"getItem",1111);
		System.out.println("getItem => "+result);
	}
}
