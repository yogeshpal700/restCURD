package com.yogi.java.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.core.Cookie;

import org.springframework.http.HttpHeaders;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.yogi.java.beans.Customer;
import com.yogi.java.service.CustomerService;
import com.yogi.java.service.TicketDetailsService;
import com.yogi.java.service.TicketService;

@RestController
public class CustomerController {
	
	@Autowired
	@Qualifier("customerService")
	private CustomerService customerService;

	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private TicketDetailsService ticketDetailsService;

	public void setTicketDetailsService(TicketDetailsService ticketDetailsService) {
		this.ticketDetailsService = ticketDetailsService;
	}
	
	private TicketService ticketService;

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@RequestMapping(value="/customer1/new1" ,method=RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer,UriComponentsBuilder uri){
		
		if(customerService.isCustomeExist(customer)){
			System.out.print(customerService.isCustomeExist(customer));
			return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
		}else {
			
			customerService.addCustomer(customer);
			HttpHeaders headers=new	HttpHeaders();
			headers.setLocation(uri.path("/customer1/{customerId}").buildAndExpand(customer.getCustomerId()).toUri());
			return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
		}
		
	}
	@RequestMapping(value="/customer1/{customerId}", method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<Customer> getCustomerId(@PathVariable("customerId")int customerId){
		Customer customer=customerService.getCustomerId(customerId);
		if(customer==null){
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}else{
			System.out.println("Name: "+customer.getAge()+" id: "+customerId+" lastname "+customer.getLastname());

			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		
	}
	@RequestMapping(value="/customer1" , method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> cList=new ArrayList<>();
		cList=customerService.getAllCustomer();
		if(cList==null)
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Customer>>(cList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer1/name1/{name}" , method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<Customer> getCustomerName(@PathVariable("name")String name){
			Customer customer=customerService.getCustomerName(name);
			if(customerService.isCustomeExist(customer))
				return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<Customer>(customer , HttpStatus.OK);
		
	}
	
	
	
}



