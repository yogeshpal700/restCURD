package com.yogi.java.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.xml.namespace.QName;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.java.beans.MyCustomer;
import com.yogi.java.dao.CustomerDAO;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public MyCustomer getCustomerId(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		MyCustomer myCustomer = new MyCustomer();
		try {
			myCustomer = (MyCustomer) session.get(MyCustomer.class, id);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
		}

		return myCustomer;
	}

	@Override
	public MyCustomer getCustomerName(String name) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		MyCustomer  myCustomer=new MyCustomer();
		String hql="from com.yogi.java.beans.MyCustomer where name=?";
		try{
			org.hibernate.Query query=session.createQuery(hql);
			query.setParameter(0, name);
			myCustomer= (MyCustomer)query.uniqueResult();
			System.out.println("email:" +myCustomer.getEmail());
			transaction.commit();
			session.close();
		}catch(Exception e){
			transaction.commit();
			session.close();
			
		}
		
		return myCustomer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyCustomer> getAllCustomer() {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<MyCustomer> myCustomer=new ArrayList<>();
		try{
		org.hibernate.Query q=	session.createQuery("from com.yogi.java.beans.MyCustomer");
		myCustomer=(List<MyCustomer>)q.list();
		transaction.commit();
		session.close();
		}catch(Exception e){
			transaction.rollback();
			session.close();
		}
		return myCustomer;
	}

	@Override
	public void addCustomer(MyCustomer myCustomer) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (myCustomer != null) {
			try {
				session.save(myCustomer);
				transaction.commit();

			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}
		}
	}

	@Override
	public void editCustomer(MyCustomer myCustomer) {

	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.openSession();

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean isCustomeExist() {
		// TODO Auto-generated method stub
		return false;
	}

}
