package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.service.spring.domain.MyProduct;

public class MyBatisMyProductJunitTest {
	private static final String NS = "ns.sql.MyProductMapper.";
	private SqlSession getSqlSession() throws Exception{
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		return session;
	}
	

	 @Test public void addProduct() throws Exception{ 
	 SqlSession session=getSqlSession(); 
	 MyProduct product = new MyProduct("노트북","LG",2070000); session.insert(NS+"addProduct",product);
	 session.commit(); session.close();
	 }

	
	@Test
	public void findProductByName()throws Exception {
		SqlSession session=getSqlSession();
		List<MyProduct> list = session.selectList(NS+"findProductByName","선풍기");
		list.forEach(c->System.out.println("findProductByName => "+c));
		System.out.println("============================");
	}
	
	@Test
	public void findProductByMaker()throws Exception {
		SqlSession session=getSqlSession();
		List<MyProduct> list = session.selectList(NS+"findProductByMaker","엘지");
		list.forEach(c->System.out.println("findProductByMaker => "+c));
		System.out.println("============================");
	}
	
	@Test
	public void findProducts()throws Exception {
		SqlSession session=getSqlSession();
		List<MyProduct> list = session.selectList(NS+"findProducts");
		list.forEach(c->System.out.println("findProducts =>"+c));
		System.out.println("============================");
	}

}
