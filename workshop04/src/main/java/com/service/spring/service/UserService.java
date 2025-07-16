package com.service.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.UserDAO;
import com.service.spring.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public User getUser(User user) throws Exception {
		return userDAO.getUser(user);

	}

	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
	}
}
