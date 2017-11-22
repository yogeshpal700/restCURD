package com.yogi.java.dao;

import java.util.List;

import com.yogi.java.beans.MyCustomer;
import com.yogi.java.beans.Ticket;

public interface Ticket_DAO{
	
	public Ticket getTicketId(int id);
	public Ticket getTicketName(String name);
	public List<Ticket> getAllTicket();
	public void addTicket(Ticket ticket);
	public void editTicket(Ticket ticket);
	public void deleteTicket(int id);
	public void deleteAll();
	boolean isTicketExist();
	 	
}
