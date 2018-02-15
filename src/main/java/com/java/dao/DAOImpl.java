package com.java.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.bean.User;

public class DAOImpl implements Operations<User>{

	public boolean add(User t) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		s.save(t);
		tr.commit();
		s.close();
		return true;
	}

	public User get(int primaryKey) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		User u = s.get(User.class, primaryKey);
		tr.commit();
		s.close();
		return u;
	}

	public List<User> getAll() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		List<User> l = s.createQuery("from User").list();
		tr.commit();
		s.close();
		return l;
	}

	public User update(User t) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		s.update(t);
		tr.commit();
		s.close();
		return t;
	}

	public boolean delete(int primaryKey) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = s.beginTransaction();
		s.delete(get(primaryKey));
		tr.commit();
		s.close();
		return false;
	}

}
