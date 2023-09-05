package com.nagarro.assignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.assignment.entity.User;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private List<User> users;
	
	public List<User> getAllUsers(){
		users = this.hibernateTemplate.loadAll(User.class);
		return users;
	}
}
