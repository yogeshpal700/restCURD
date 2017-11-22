package com.yogi.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.java.DaoImpl.CustomerDaoImpl;
import com.yogi.java.DaoImpl.Customer_DAOIMPL;
import com.yogi.java.beans.Customer;
import com.yogi.java.dao.Customer_DAO;
import com.yogi.java.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private Customer_DAO customerDAO;
	
	
	public Customer_DAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(Customer_DAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public Customer getCustomerId(int id) {
		return customerDAO.getCustomerId(id);
	}

	@Override
	public String showFirstName(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerName(String name) {
		return customerDAO.getCustomerName(name);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDAO.getAllCustomer();
	}

	@Override
	public Customer loginCustomer(String mail, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer customer1) {
		customerDAO.addCustomer(customer1);
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
		// TODO Auto-generated method stub
		return customerDAO.isCustomeExist(customer);
	}

	
}
