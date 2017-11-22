package com.yogi.java.dao;

import java.util.List;

import com.yogi.java.beans.Customer;
import com.yogi.java.beans.MyCustomer;

public interface Customer_DAO{
	
	public Customer getCustomerId(int id);
	
	public String showFirstName(String mail);
	
	public Customer getCustomerName(String name);
	
	public List<Customer> getAllCustomer();
	
	public Customer loginCustomer(String mail, String password);
	
	public void addCustomer(Customer customer);
	
	public void editCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public void deleteAll();
	
	boolean isCustomeExist(Customer customer);
	 	
}
