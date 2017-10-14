package com.yogi.java.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.yogi.java.beans.MyCustomer;
import com.yogi.java.service.MyCustomerService;

@RestController
public class MyRestController {

	@Autowired
	@Qualifier("myCustomerService")
	private MyCustomerService myCustomerService;

	public MyCustomerService getMyCustomerService() {
		return myCustomerService;
	}

	public void setMyCustomerService(MyCustomerService myCustomerService) {
		this.myCustomerService = myCustomerService;
	}

	@RequestMapping(value = "/customer/new/", method = RequestMethod.POST)
	public ResponseEntity<Void> addCustomer(@RequestBody MyCustomer myCustomer,
			UriComponentsBuilder ucb) {
		if (myCustomerService.isCustomeExist()) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			myCustomerService.addCustomer(myCustomer);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/customer/{id}")
					.buildAndExpand(myCustomer.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML)
	public ResponseEntity<MyCustomer> getCustomer(@PathVariable("id")int id) {
		MyCustomer myCustomer = myCustomerService.getCustomerId(id);
		if (myCustomer == null) {
			return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);

		} else {
			System.out.println("i an in get ok");
			System.out.println("Name: "+myCustomer.getName()+" Email: "+myCustomer.getEmail());
			return new ResponseEntity<MyCustomer>(myCustomer,HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/customer/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML)
	public ResponseEntity<MyCustomer> getCustomerName(@PathVariable("name")String name) {
		MyCustomer myCustomer = myCustomerService.getCustomerName(name);

		if (myCustomer == null) {
			System.out.println("i an in get ok name null");
			return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
		} else {
			System.out.println("Name: "+myCustomer.getName()+" Email: "+myCustomer.getEmail());

			return new ResponseEntity<MyCustomer>(myCustomer,HttpStatus.OK);
		}

	}
	@RequestMapping(name="/customer", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<List<MyCustomer>> getAll(){
			List<MyCustomer> myCustomer=myCustomerService.getAllCustomer();
			if(myCustomer==null){
				System.out.println("i an in get ok name null");
				return new ResponseEntity<List<MyCustomer>>(HttpStatus.NO_CONTENT);
			}else{
				System.out.println("i an in get ok name ");
				return new ResponseEntity<List<MyCustomer>>(myCustomer, HttpStatus.OK);
			}
		
	}

}