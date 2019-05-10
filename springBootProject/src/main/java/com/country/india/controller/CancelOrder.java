package com.country.india.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelOrder {
	
	@RequestMapping(consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE}, value="/cancelOrder", method= {RequestMethod.GET})
    public ResponseEntity<HttpStatus> createOrder(@RequestParam(value="name") String name) {
		
		System.out.println("Successfully invoked the cancel order REST");
       
		return new ResponseEntity(HttpStatus.OK);
    }
	
	@RequestMapping(consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE}, value="/cancelOrder/uriComponentBuilder/requestParam", method= {RequestMethod.GET})
    public ResponseEntity<HttpStatus> createOrderRequestParam(@RequestParam("name") String name) {
		
		System.out.println("Successfully invoked the cancel order REST");
       
		return new ResponseEntity(HttpStatus.OK);
    }
	
	@RequestMapping(consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE}, value="/cancelOrder/uriComponentBuilder/{name}", method= {RequestMethod.GET})
    public ResponseEntity<HttpStatus> createOrderPathParam(@PathVariable("name") String name) {
		
		System.out.println("Successfully invoked the cancel order REST");
       
		return new ResponseEntity(HttpStatus.OK);
    }

}
