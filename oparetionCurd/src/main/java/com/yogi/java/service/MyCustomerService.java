package com.yogi.java.service;

import java.util.List;

import com.yogi.java.beans.MyCustomer;

public interface MyCustomerService {
	
	public MyCustomer getCustomerId(int id);
	public MyCustomer getCustomerName(String name);
	public List<MyCustomer> getAllCustomer();
	public void addCustomer(MyCustomer myCustomer);
	public void editCustomer(MyCustomer myCustomer);
	public void deleteCustomer(int id);
	public void deleteAll();
	boolean isCustomeExist();

}
