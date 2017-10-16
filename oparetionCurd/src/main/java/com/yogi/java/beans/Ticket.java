package com.yogi.java.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Ticket {
	
	@Id
	@GeneratedValue
	@Column
	private int ticketId;
	@Column
	private int ticketdetailsId;
	@Column
	private int typeId;
	@Column
	@NotNull
	private String name;
	
	
	public Ticket(int ticketId, int ticketdetailsId, int typeId, String name) {
		super();
		this.ticketId = ticketId;
		this.ticketdetailsId = ticketdetailsId;
		this.typeId = typeId;
		this.name = name;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getTicketdetailsId() {
		return ticketdetailsId;
	}
	public void setTicketdetailsId(int ticketdetailsId) {
		this.ticketdetailsId = ticketdetailsId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
