package com.mobil.ws.application.repository.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobil.ws.domain.customer.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	  List<Customer> findAllCustomer();
}
