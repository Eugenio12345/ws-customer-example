package com.mobil.ws.application.repository.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobil.ws.domain.customer.CustomerDto;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDto, Integer>{

	List<CustomerDto> findAllCustomer();

}
