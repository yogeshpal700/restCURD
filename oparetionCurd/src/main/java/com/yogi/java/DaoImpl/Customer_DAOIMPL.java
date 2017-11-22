package com.yogi.java.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.java.beans.Customer;
import com.yogi.java.beans.MyCustomer;
import com.yogi.java.dao.Customer_DAO;

@Repository
public class Customer_DAOIMPL implements Customer_DAO {

	@Autowired
	private SessionFactory sessionFactory= null;
	
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Customer getCustomerId(int customerId) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Customer customer=new Customer();
		String hql="from com.yogi.java.beans.Customer where customerId=?";
		try{
			org.hibernate.Query query=session.createQuery(hql);
			query.setParameter(0, customerId);
			customer= (Customer)query.uniqueResult();
			System.out.println("email:" +customer.getEmail());
			transaction.commit();
			session.close();
		}catch(Exception e){
			transaction.commit();
			session.close();	
		}
		
		return customer;
	}
	

	@Override
	public String showFirstName(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerName(String name) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Customer customer=new Customer();
		//String sql=""
		try{
		Criteria criteria=session.createCriteria(Customer.class);
		
		Criterion criterion=Restrictions.eq("name", name);
		criteria.add(criterion);
		customer=(Customer)criteria.uniqueResult();
		transaction.commit();
		session.close();
		}catch(Exception exception){
			transaction.rollback();
			session.close();
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Customer> listCustomers=new ArrayList<Customer>();
		String sql="from com.yogi.java.beans.Customer";
		try{
			Query query=session.createQuery(sql);
			listCustomers=query.list();
			transaction.commit();
			session.close();
			}catch(Exception exception){
			transaction.rollback();
			session.close();
		}
		return listCustomers;
	}

	@Override
	public Customer loginCustomer(String mail, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		 
	Session session=sessionFactory.openSession();
	Transaction transaction=session.beginTransaction();
	try{
		
		session.save(customer);
		transaction.commit();
		session.close();
		
	}catch(Exception exception){
		transaction.rollback();
		session.close();
		
	}
		
	}

	@Override
	public void editCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCustomeExist(Customer customer) {
		if(customer==null)
		return true;
		else
		return false;
	}

}
