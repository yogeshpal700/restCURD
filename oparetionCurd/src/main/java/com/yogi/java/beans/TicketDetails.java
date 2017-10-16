package com.yogi.java.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

public class TicketDetails implements Serializable{ 

		private static final long serializnumber=-5348709123498653576L;	
		@Id
		@GeneratedValue
		@Column
		private int ticketdetailsId;
		@Column
		private int customerId;
		@Column
		private int flightId;
		@Column
		private int totalclient;
		@Column
		private String totalprice;
		@Column
		private String totaltex;
		@Column
		private boolean confirm;
		@Column
		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinColumn(name="ticketId")
		@LazyCollection(LazyCollectionOption.FALSE)
		@OrderBy("customerId")
		@Fetch(value=FetchMode.SUBSELECT)
		private List<Ticket> tickets;
				
		
		public TicketDetails(int ticketdetailsId, int customerId, int flightId,
				int totalclient, String totalprice, String totaltex,
				boolean confirm, List<Ticket> tickets) {
			super();
			this.ticketdetailsId = ticketdetailsId;
			this.customerId = customerId;
			this.flightId = flightId;
			this.totalclient = totalclient;
			this.totalprice = totalprice;
			this.totaltex = totaltex;
			this.confirm = confirm;
			this.tickets = tickets;
		}

		public TicketDetails() {
			// TODO Auto-generated constructor stub
		}

		public int getTicketdetailsId() {
			return ticketdetailsId;
		}

		public void setTicketdetailsId(int ticketdetailsId) {
			this.ticketdetailsId = ticketdetailsId;
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public int getFlightId() {
			return flightId;
		}

		public void setFlightId(int flightId) {
			this.flightId = flightId;
		}

		public int getTotalclient() {
			return totalclient;
		}

		public void setTotalclient(int totalclient) {
			this.totalclient = totalclient;
		}

		public String getTotalprice() {
			return totalprice;
		}

		public void setTotalprice(String totalprice) {
			this.totalprice = totalprice;
		}

		public String getTotaltex() {
			return totaltex;
		}

		public void setTotaltex(String totaltex) {
			this.totaltex = totaltex;
		}

		public boolean isConfirm() {
			return confirm;
		}

		public void setConfirm(boolean confirm) {
			this.confirm = confirm;
		}

		public List<Ticket> getTickets() {
			return tickets;
		}

		public void setTickets(List<Ticket> tickets) {
			this.tickets = tickets;
		}

		public static long getSerializnumber() {
			return serializnumber;
		}
		
		
}
