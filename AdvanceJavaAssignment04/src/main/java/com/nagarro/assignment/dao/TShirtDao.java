package com.nagarro.assignment.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.assignment.entity.TShirt;

@Repository
public class TShirtDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void loadOne(TShirt tshirt) {
		hibernateTemplate.save(tshirt);
	}
	
	public List<TShirt> getAllShirts(){
		return hibernateTemplate.loadAll(TShirt.class);
	}
	
	@Transactional
	public void loadItemsIntoDB(List<TShirt> tshirts) {
		for(TShirt tshirt: tshirts) {
			
			hibernateTemplate.save(tshirt);
		}
	}
}
