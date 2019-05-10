package com.country.india.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.india.model.Order;
import com.country.india.util.OrderUtil;

@Service
public class OuterOrderService {

	@Autowired
	InnerOrderService innerOrderService;

	public void thisHasCallToVoidMethod(String name) {

		voidMethod(name);

	}


	public Order createNewObject(String name) {

		Order order = refactorToMoveCreationLogic();
		System.out.println(order.getName());
		return order;
	}


	public int callsUtilstaticMethod(String name) {

		System.out.println("calls util method which can have a service call or session");
		int calculatedValue = OrderUtil.calculate(new String("hello"));
		return calculatedValue;
	}
	
	void voidMethod(String name) {
		innerOrderService.voidMethod("mahender");
	}
	
	public Order refactorToMoveCreationLogic() {
		Order order = new Order();
		order.setName("Real name");
		return order;
	}

}
