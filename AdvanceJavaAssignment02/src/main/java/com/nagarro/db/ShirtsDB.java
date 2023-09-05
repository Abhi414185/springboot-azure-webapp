package com.nagarro.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.entity.Tshirts;
import com.nagarro.hibernate.hibernate;

public class ShirtsDB {
	public void addList(List<Tshirts> list) {
		Transaction transaction = null;
		try(Session session = hibernate.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			for(Tshirts shirt : list) {
				session.save(shirt);
			}
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	
	}
	public List<Tshirts> getTshirts(){
		try(Session session = hibernate.getSessionFactory().openSession()){
			return session.createQuery("from TShirts", Tshirts.class).list();
		}
	}
}
