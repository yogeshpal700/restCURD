package com.yogi.java.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "flight")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlRootElement
public class Flight {
	
	@Id
	@GeneratedValue//hellofgbgfhfgf
	@Column
	private int flightId;
	@Column
	private String DepartTime;
	@Column
	@NotEmpty
	private String origin;
	@Column
	@NotEmpty
	private String desctination;
	@Column
	private int numberfoseats;
	@Column
	private int price;
	
	@Column
	@OneToMany(cascade=javax.persistence.CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="flightId")
	@OrderBy("flightId")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value=FetchMode.SUBSELECT)
	private Set<TicketDetails> ticketDetails;
	
	public Flight() {
	}

	public Flight(int flightId, String departTime, String origin,
			String desctination, int numberfoseats, int price,
			Set<TicketDetails> ticketDetails) {
		super();
		this.flightId = flightId;
		DepartTime = departTime;
		this.origin = origin;
		this.desctination = desctination;
		this.numberfoseats = numberfoseats;
		this.price = price;
		this.ticketDetails = ticketDetails;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getDepartTime() {
		return DepartTime;
	}

	public void setDepartTime(String departTime) {
		DepartTime = departTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDesctination() {
		return desctination;
	}

	public void setDesctination(String desctination) {
		this.desctination = desctination;
	}

	public int getNumberfoseats() {
		return numberfoseats;
	}

	public void setNumberfoseats(int numberfoseats) {
		this.numberfoseats = numberfoseats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<TicketDetails> getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(Set<TicketDetails> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	
	
	
	

}
