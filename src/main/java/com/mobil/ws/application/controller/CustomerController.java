package com.mobil.ws.application.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobil.ws.application.service.GenericService;
import com.mobil.ws.domain.customer.Customer;

@Controller
@RequestMapping(value = "/api")
public class CustomerController {

	private GenericService<Customer> customerService;

	@Autowired
	public CustomerController(GenericService<Customer> customerService) {
		this.customerService = customerService;
	}

	/**
	 * 
	 * @param idCustomer
	 * @return CustomerRequest
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/customer/query/{idCustomer}")
	public ResponseEntity<Customer> getCustomer(@PathVariable String idCustomer) {
		Customer cuRequest = new Customer();
		cuRequest.setApellidoMaterno("Merino");
		cuRequest.setApellidoPaterno("Merino");
		cuRequest.setDireccion("Calle Reforma No.2");
		cuRequest.setIdCliente(1);
		cuRequest.setNombre("Eugenio");
		return new ResponseEntity<Customer>(cuRequest, HttpStatus.OK);
	}

	/**
	 * 
	 * @param request
	 * @return void method
	 * @throws SQLException
	 */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/customer/save")
	public ResponseEntity<Void> saveCustomer(@RequestBody Customer request) throws SQLException {
		customerService.saveOrUpdate(request);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/customer/query")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(this.customerService.getAll(), HttpStatus.OK);
	}
}
