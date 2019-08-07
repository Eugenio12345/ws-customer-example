package com.mobil.ws.application.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.aggregator.CustomerAggregator;
import com.mobil.ws.application.service.CustomerService;
import com.mobil.ws.domain.customer.CustomerRequest;

@Component
public class CustomerServiceImpl implements CustomerService<CustomerRequest> {

	
	CustomerAggregator<CustomerRequest> customerAggregator;
	
	@Autowired
	public  CustomerServiceImpl(CustomerAggregator<CustomerRequest> customerAggregator) throws SQLException{
		this.customerAggregator = customerAggregator;
	}

	@Override
	public void saveOrUpdate(CustomerRequest t) throws SQLException {
         this.customerAggregator.saveObject(t);
	}

	@Override
	public List<CustomerRequest> getAll() {
		return customerAggregator.getAll();
	}
	
}
