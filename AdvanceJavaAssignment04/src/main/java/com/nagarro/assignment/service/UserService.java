package com.nagarro.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.assignment.dao.UserDao;
import com.nagarro.assignment.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean verifyUserDetails(User user) {
		List<User> users = this.userDao.getAllUsers();
		for(User u:users) {
			if(user.getUsername().equals(u.getUsername()) && user.getPassword().equalsIgnoreCase(u.getPassword())) {
				return true;
			}
		}
		
		return false;
	}
}
