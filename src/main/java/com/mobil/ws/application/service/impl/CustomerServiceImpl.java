package com.mobil.ws.application.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.aggregator.CustomerAggregator;
import com.mobil.ws.application.service.GenericService;
import com.mobil.ws.domain.customer.Customer;

@Component
public class CustomerServiceImpl implements GenericService<Customer> {

	
	CustomerAggregator<Customer> customerAggregator;
	
	@Autowired
	public  CustomerServiceImpl(CustomerAggregator<Customer> customerAggregator) throws SQLException{
		this.customerAggregator = customerAggregator;
	}

	@Override
	public void saveOrUpdate(Customer request) throws SQLException {
         this.customerAggregator.saveOrUpdate(request);
	}

	@Override
	public List<Customer> getAll() {
		return customerAggregator.getAll();
	}

	@Override
	public Customer findId(Integer id) {
		return customerAggregator.findById(id);
	}
	
}
