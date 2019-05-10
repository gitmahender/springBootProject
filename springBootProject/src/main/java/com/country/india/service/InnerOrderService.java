package com.country.india.service;

import org.springframework.stereotype.Service;

import com.country.india.model.Order;
import com.country.india.util.OrderUtil;

@Service
public class InnerOrderService {
	
	private int age;

	public void voidMethod(String name) {

		System.out.println("void method");
	}

	public Order createNewObject(String name) {

		System.out.println("create new object method");
		Order order = new Order();
		return order;
	}
	
	public static Order staticMethod(String name) {

		System.out.println("static method");
		Order order = new Order();
		return order;
	}
	
	public int callsUtilstaticMethod(String name) {

		System.out.println("calls util method which can have a service call or session");
		int calculatedValue = OrderUtil.calculate(new String("hello"));
		return calculatedValue;
	}

}
