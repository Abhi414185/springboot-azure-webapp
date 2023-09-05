package com.nagarro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.entity.Item;
import com.nagarro.Util.HibernateUtil;

public class ItemDao {
	public void addList(List<Item> list) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			for(Item item : list) {
				session.save(item);
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
	public void addItem(Item item) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(item);
			
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public List<Item> getItemList(){
		List<Item> list=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from com.nagarro.entity.Item");
		list = query.list();
		
		return list;
	}
	
	public void delete(Item item) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.remove(item);
			
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public void updateChanges(Item item) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.update(item);
			
			transaction.commit();
			session.close();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public Item getItemById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Item item = session.get(Item.class, id);
		return item;
	}
	
}
