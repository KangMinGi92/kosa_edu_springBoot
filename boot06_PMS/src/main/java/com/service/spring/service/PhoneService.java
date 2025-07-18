package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Service
public class PhoneService {
	
	@Autowired
	private PhoneDAO phoneDAO;
	
	public int insert(Phone phone)throws Exception {
		return phoneDAO.insert(phone);
	}
	
	public int delete(List<String> list)throws Exception {
		return phoneDAO.delete(list);
	}
	
	public int update(Phone phone)throws Exception {
		return phoneDAO.update(phone);
	}
	
	public Phone select(Phone phone)throws Exception {
		return phoneDAO.select(phone);
	}
	
	public List<Phone> select()throws Exception {
		return phoneDAO.select();
	}
	
	public UserInfo select(UserInfo user)throws Exception {
		return phoneDAO.select(user);
	}
}
