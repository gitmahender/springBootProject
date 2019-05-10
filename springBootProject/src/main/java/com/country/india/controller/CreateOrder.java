package com.country.india.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.country.india.controller.client.CreateOrderRestClient;

@RestController
public class CreateOrder {
	
	@Autowired
	CreateOrderRestClient createOrderRestClient;
	
	@RequestMapping(value="/createOrder", method= {RequestMethod.GET})
    public ResponseEntity<HttpStatus> createOrder(@RequestParam(value="name") String name) throws URISyntaxException {
		
		System.out.println("Successfully invoked the create order rest controller");
		
		createOrderRestClient.createUsingURIRestTemplete();
		
		createOrderRestClient.createRestTempleteUsingUriComponentBuilderRequestParam();
		
		createOrderRestClient.createRestTempleteUsingPathParam();
       
		return new ResponseEntity(HttpStatus.OK);
    }

}
