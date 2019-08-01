package org.test.example.controller;


import org.junit.Test;

import com.mobil.ws.application.controller.CustomerController;

public class CustomerControllerTest {

	
	CustomerController customerController;
	
	
	@Test
	public void initData(){
		customerController = new CustomerController();
		customerController.getMessage();
	}
}
