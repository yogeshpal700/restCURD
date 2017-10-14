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

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlRootElement
public class Customer {
	
	@Id
	@GeneratedValue
	@Column
	private int customerId;
	@Column
	private String name;
	@Column
	private String lastname;
	@Column
	private String passworg;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private String city;
	@Column
	private int pin;
	@Column
	@NotEmpty
	private String phone;
	
	@Column
	@OneToMany(cascade=javax.persistence.CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="customerId")
	@OrderBy("customerId")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value=FetchMode.SUBSELECT)
	private Set<TicketDetails> ticketDetails;
	
	public Customer() {
	}

	public Customer(int customerId, String name, String lastname,
			String passworg, String gender, int age, String email, String city,
			int pin, String phone, Set<TicketDetails> ticketDetails) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.lastname = lastname;
		this.passworg = passworg;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.city = city;
		this.pin = pin;
		this.phone = phone;
		this.ticketDetails = ticketDetails;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassworg() {
		return passworg;
	}

	public void setPassworg(String passworg) {
		this.passworg = passworg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<TicketDetails> getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(Set<TicketDetails> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	
	
	

}
