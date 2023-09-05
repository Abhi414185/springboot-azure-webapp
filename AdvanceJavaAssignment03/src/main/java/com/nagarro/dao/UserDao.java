package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.entity.User;
import com.nagarro.Util.HibernateUtil;

public class UserDao {
	public List<User> getItemList(){
		List<User> list=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from com.nagarro.entity.User");
		list = query.list();
		
		return list;
	}
}
