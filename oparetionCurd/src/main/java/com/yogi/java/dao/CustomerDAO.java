package com.yogi.java.dao;

import java.util.List;

import com.yogi.java.beans.MyCustomer;

public interface CustomerDAO{
	
	public MyCustomer getCustomerId(int id);
	public MyCustomer getCustomerName(String name);
	public List<MyCustomer> getAllCustomer();
	public void addCustomer(MyCustomer myCustomer);
	public void editCustomer(MyCustomer myCustomer);
	public void deleteCustomer(int id);
	public void deleteAll();
	boolean isCustomeExist();
	 	
}
