package com.mobil.ws.application.repository.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mobil.ws.domain.customer.CustomerRequest;

public interface CustomerRepository extends CrudRepository<CustomerRequest, Integer>{

	  List<CustomerRequest> findByNombre(String nombre);

}
