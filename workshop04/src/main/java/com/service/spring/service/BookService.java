package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.BookDAO;
import com.service.spring.domain.Book;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDAO;

	public void insertBook(Book vo) throws Exception {
		bookDAO.insertBook(vo);
	}

	public List<Book> getBooks() throws Exception {
		return bookDAO.getBooks();
	}

	public List<Book> searchByTitle(String word) throws Exception {
		return bookDAO.searchByTitle(word);
	}

	public List<Book> searchByPublisher(String word) throws Exception {
		return bookDAO.searchByPublisher(word);
	}

	public List<Book> searchByPrice(int price) throws Exception {
		return bookDAO.searchByPrice(price);
	}

	public Book searchByIsbn(String word) throws Exception {
		return bookDAO.searchByIsbn(word);
	}

	public void delete(String word) throws Exception {
		bookDAO.delete(word);
	}

	public Book getIsbn(String isbn) throws Exception {
		return bookDAO.getIsbn(isbn);
	}

	public void update(Book vo) throws Exception {
		bookDAO.update(vo);
	}
}
