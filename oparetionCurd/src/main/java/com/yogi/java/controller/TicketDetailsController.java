package com.yogi.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.yogi.java.service.TicketDetailsService;

@RestController
public class TicketDetailsController {
	
	@Autowired
	@Qualifier
	TicketDetailsService ticketDetailsService;

	public TicketDetailsService getTicketDetailsService() {
		return ticketDetailsService;
	}

	public void setTicketDetailsService(TicketDetailsService ticketDetailsService) {
		this.ticketDetailsService = ticketDetailsService;
	}
	
	
	
	

}
