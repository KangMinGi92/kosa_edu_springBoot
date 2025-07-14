package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.Item;

public class MyBatisUnitTest {
	
	private static final String NS ="ns.sql.FruitMapper.";
	public static void main(String[] args) throws Exception {
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		Item item = new Item();
		
		List<Item> list=session.selectList(NS+"getItemList", item);
		list.forEach(c->System.out.println("getItemList => "+c));
		
		item.setItemNumber(1111);
		Item result = session.selectOne(NS+"getItem",item.getItemNumber());
		System.out.println("getItem => "+result);
	}

}
