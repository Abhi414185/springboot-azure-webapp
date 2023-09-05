package com.nagarro.servicesImpl;

import java.util.Base64;
import java.util.List;

import com.nagarro.dao.ItemDao;
import com.nagarro.entity.Item;
import com.nagarro.services.ItemList;

public class ListOfItems implements ItemList {

	@Override
	public List<Item> getAllItems() {
		ItemDao dao = new ItemDao();
		List<Item> itemList = dao.getItemList();
		for(Item item : itemList) {
			if(item.getImage()==null || item.getImage().length == 0) {
				item.setBase64Image(null);
			}
			else {
				item.setBase64Image(Base64.getEncoder().encodeToString(item.getImage()));
			}
		}
		return itemList;
	}

}
