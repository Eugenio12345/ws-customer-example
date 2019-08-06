package com.mobil.ws.application.aggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.repository.customer.CustomerRepository;
import com.mobil.ws.domain.customer.CustomerRequest;

@Component
public class CustomerAggregator<T> {

	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerAggregator(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	public void saveObject (T object){
		
		if(object instanceof CustomerRequest){
			this.customerRepository.save((CustomerRequest)object);
		}
		
		
	}
}
