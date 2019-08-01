package com.mobil.ws.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/v1/mobile/customer")
public class CustomerController {

	
	@RequestMapping(method = RequestMethod.GET,value="/consulta",produces = "application/json" )
	@ResponseBody
	public String getMessage(){
		return "hello world";
	}
}
