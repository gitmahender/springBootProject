package com.country.india.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateOrder {
	
	@GetMapping("/createOrder")
    public ResponseEntity<HttpStatus> createOrder(@RequestParam(value="name") String name) {
		
		System.out.println("Successfully invoked the rest controller");
       
		return new ResponseEntity(HttpStatus.OK);
    }

}
