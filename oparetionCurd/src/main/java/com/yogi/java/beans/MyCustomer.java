package com.yogi.java.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mycustomer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlRootElement
public class MyCustomer {

	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private String city;
	@Column
	private int pin;

	public MyCustomer() {
		// TODO Auto-generated constructor stub
	}

	public MyCustomer(int id, String name, int age, String email, String city,
			int pin) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.city = city;
		this.pin = pin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
