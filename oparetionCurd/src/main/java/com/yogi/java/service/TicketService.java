package com.yogi.java.service;

import java.util.List;

import com.yogi.java.beans.Customer;
import com.yogi.java.beans.Ticket;

public interface TicketService {

	public Ticket getTicketId(int id);
	
	public String showFirstName(String mail);
	
	public Ticket getTicketName(String name);
	
	public List<Ticket> getAllTicket();
	
	public void addTicket(Ticket ticket);
	
	public void editTicket(Ticket ticket);
	
	public void deleteTicket(int id);
	
	public void deleteAll();
	
	boolean isTicketExist();
}
