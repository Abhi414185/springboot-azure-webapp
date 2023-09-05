package com.nagarro.servicesImpl;

import java.util.List;

import com.nagarro.dao.UserDao;
import com.nagarro.entity.User;
import com.nagarro.services.ValidateUser;

public class UserValidation implements ValidateUser {

	@Override
	public boolean validate(User user) {
		List<User> users = new UserDao().getItemList();
		for (User u : users) {
			if (u.getUsername().equals(user.getUsername()) && u.getPassword().equalsIgnoreCase(user.getPassword())) {

				return true;
			}
			
		}
		return false;
	}
}
