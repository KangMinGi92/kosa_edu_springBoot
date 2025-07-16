package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.service.spring.domain.Book;


public class BookJunitTest {
	private static final String NS = "ns.sql.BookMapper.";
	private SqlSession getSqlSession()throws Exception{
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		return session;
	}
	
	@Test
	public void insertBook()throws Exception {
		SqlSession session = getSqlSession();
		Book book = new Book("1233-111-444","Java 완성2","프로그래밍","국내도서","2020.02.05","사무국","사무국",4000,"Java를 마시자2");
		System.out.println(session.insert(NS+"insertBook",book));
		session.commit();

	}
	
	@Test
	public void getBooks()throws Exception {
		SqlSession session = getSqlSession();
		List<Book> list = session.selectList(NS+"getBooks");
		list.forEach(c->System.out.println(c));
	}
	
	@Test
	public void searchByTitle()throws Exception {
		SqlSession session = getSqlSession();
		Book book = session.selectOne(NS+"searchByTitle","Clean");
		System.out.println(book);
	}
	
	@Test
	public void searchByPublisher()throws Exception {
		SqlSession session = getSqlSession();
		Book book = session.selectOne(NS+"searchByPublisher","한빛미디어");
		System.out.println(book);
	}
	
	@Test
	public void searchByPrice()throws Exception {
		SqlSession session = getSqlSession();
		List<Book> list = session.selectList(NS+"searchByPrice",6000);
		list.forEach(c->System.out.println(c));
	}
	
	@Test
	public void searchByIsbn()throws Exception {
		SqlSession session = getSqlSession();
		Book book = session.selectOne(NS+"searchByIsbn","1123-111-111");
		System.out.println(book);
	}
	@Test
	public void delete()throws Exception{
		SqlSession session = getSqlSession();
		System.out.println(session.delete(NS+"delete","1123-111-111"));
		session.commit();
	}

	@Test
	public void getIsbn()throws Exception {
		SqlSession session = getSqlSession();
		Book book = session.selectOne(NS+"searchByIsbn","1123-111-111");
		System.out.println(book);
	}
	
	@Test
	public void update()throws Exception{
		SqlSession session = getSqlSession();
		Book book = new Book();
		book.setIsbn("1233-111-444");
		book.setTitle("CleanCode");
		book.setAuthor("Kosa");
		book.setDescription("CleanCode작성방법");
		System.out.println(session.update(NS+"update",book));
		session.commit();
	}
}
