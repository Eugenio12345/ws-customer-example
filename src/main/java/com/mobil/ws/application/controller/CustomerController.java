package com.mobil.ws.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/v1/mobile/customer")
public class CustomerController {

	@RequestMapping(value="/consulta")
	public String getMessage(){
		return "hello world";
	}
	
}
