package com.mobil.ws.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobil.ws.domain.customer.CustomerRequest;

@Controller
@RequestMapping(value = "/api")
public class CustomerController {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/customer/query/{idCustomer}")
	public ResponseEntity<CustomerRequest>getCustomer(@PathVariable String idCustomer){
	  CustomerRequest cuRequest = new  CustomerRequest();
	  cuRequest.setApellidoMaterno("Merino");
	  cuRequest.setApellidoPaterno("Merino");
	  cuRequest.setDireccion("Calle Reforma No.2");
	  cuRequest.setIdCliente(1);
	  cuRequest.setNombre("Eugenio");
	  return new ResponseEntity<CustomerRequest>(cuRequest, HttpStatus.OK);	
	}
}
