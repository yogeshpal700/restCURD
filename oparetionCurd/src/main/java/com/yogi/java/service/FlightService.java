package com.yogi.java.service;

import java.util.List;

import com.yogi.java.beans.Customer;
import com.yogi.java.beans.Flight;

public interface FlightService {
	
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
