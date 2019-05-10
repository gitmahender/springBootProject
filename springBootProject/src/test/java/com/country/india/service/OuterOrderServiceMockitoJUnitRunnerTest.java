package com.country.india.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.country.india.model.Order;

@RunWith(value = MockitoJUnitRunner.class) 
public class OuterOrderServiceMockitoJUnitRunnerTest {
	
	@InjectMocks //This will create a real new object and injects other mocks into this.
	OuterOrderService outerOrderService;
	
	@Mock
	InnerOrderService innerOrderServiceMock;
	
	@Mock
	Order orderMock;

	@Test
	public void voidMethodTest() {
			
		//Since we cannot mock methods on real object, we first convert real object into spy then we mock on spy-object
		OuterOrderService outerOrderServiceSpy = Mockito.spy(outerOrderService);
		
		//Mocking a void method, remember this is not real object but a spy-ed object
		doNothing().when(outerOrderServiceSpy).voidMethod(any(String.class));
		
		
		outerOrderServiceSpy.thisHasCallToVoidMethod("mahender");
		
	}
	
	@Test
	public void createNewObjectTest() {
			
		//Since we cannot mock methods on real object, we first convert real object into spy then we mock on spy-object
		OuterOrderService outerOrderServiceSpy = Mockito.spy(outerOrderService);
		
		//Mocking a new object creation method, remember this is not real object but a spy-ed object
		
		//***********This way of mock will execute the refactorToMoveCreationLogic***************
		//Choose this way when you want code coverage and if its okay to execute
		when(outerOrderServiceSpy.refactorToMoveCreationLogic()).thenReturn(orderMock);
		
		//**********This way of mock will not execute the refactorToMoveCreationLogic, but still works******
		//Choose this way when you strictly don't want to execute the given method
		doReturn(orderMock).when(outerOrderServiceSpy).refactorToMoveCreationLogic();
		
		when(orderMock.getName()).thenReturn("mock Mahender");
		
		outerOrderServiceSpy.createNewObject("mahender");
		
	}
}
