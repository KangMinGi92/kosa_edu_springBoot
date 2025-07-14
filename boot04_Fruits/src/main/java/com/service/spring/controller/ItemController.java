package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Item;
import com.service.spring.service.ItemCatalog;

@Controller
public class ItemController {
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@GetMapping("/itemView")
	public ModelAndView getItem(Integer itemId)throws Exception {
		Item item= itemCatalog.getItem(itemId);
		return new ModelAndView("itemView","item",item);
	}
	
	@GetMapping("/itemList")
	public ModelAndView getItemList()throws Exception {
		List<Item> itemList = itemCatalog.getItemList();
		return new ModelAndView("itemList","itemList",itemList);
	}
}
