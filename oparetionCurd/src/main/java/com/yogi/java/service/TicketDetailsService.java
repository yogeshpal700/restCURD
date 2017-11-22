package com.yogi.java.service;

import java.util.List;

import com.yogi.java.beans.TicketDetails;

public interface TicketDetailsService {
	
	public TicketDetails getTicketDetailsId(int id);
	public TicketDetails getTicketDetailsName(String name);
	public List<TicketDetails> getAllTicketDetails();
	public void addTicketDetails(TicketDetails ticketDetails);
	public void editTicketDetails(TicketDetails ticketDetails);
	public void deleteTicketDetails(int id);
	public void deleteAll();
	boolean isTicketDetailsExist();

}
