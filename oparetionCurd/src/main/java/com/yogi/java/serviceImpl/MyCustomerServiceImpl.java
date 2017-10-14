package com.yogi.java.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.java.beans.MyCustomer;
import com.yogi.java.dao.CustomerDAO;
import com.yogi.java.service.MyCustomerService;

@Service
public class MyCustomerServiceImpl implements MyCustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public MyCustomer getCustomerId(int id) {

		return customerDAO.getCustomerId(id);
	}

	@Override
	public MyCustomer getCustomerName(String name) {
		return customerDAO.getCustomerName(name);
	}

	@Override
	public List<MyCustomer> getAllCustomer() {
		return customerDAO.getAllCustomer();
	}

	@Override
	public void addCustomer(MyCustomer myCustomer) {

		customerDAO.addCustomer(myCustomer);
	}

	@Override
	public void editCustomer(MyCustomer myCustomer) {
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
	public boolean isCustomeExist() {
		// TODO Auto-generated method stub
		return false;
	}

}
