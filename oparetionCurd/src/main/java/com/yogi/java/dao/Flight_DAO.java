package com.yogi.java.dao;

import java.util.List;

import com.yogi.java.beans.Flight;
import com.yogi.java.beans.MyCustomer;

public interface Flight_DAO{
	
	public Flight getFlightId(int id);
	
	public String showFirstName(String mail);
	
	public Flight getFlightName(String name);
	
	public List<Flight> getAllFlight();
	
	public void addFlight(Flight flight);
	
	public void editFlight(Flight flight);
	
	public void deleteFlight(int id);
	
	public void deleteAll();
	
	boolean isFlightExist();

	 	
}
