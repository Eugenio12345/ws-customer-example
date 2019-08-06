package com.mobil.ws.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.aggregator.CustomerAggregator;

@Component
public class CustomerService {

	@Autowired
	CustomerAggregator customerAggregator;
	
	
}
