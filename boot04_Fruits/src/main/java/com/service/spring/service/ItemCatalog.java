package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.spring.dao.ItemDAO;
import com.service.spring.domain.Item;

/*
 * Service Layer 빈
 * 해당 레이어는 raw 데이터를 가져와서 다시 가공해서 전해주는 기능
 */
@Service
public class ItemCatalog {
	
	@Autowired
	private ItemDAO itemDao;
	
	
	public Item getItem(Integer itemid) throws Exception{
		return itemDao.getItem(itemid);
	}
	
	public List<Item> getItemList()throws Exception{
		return itemDao.getItemList();
	}
}
