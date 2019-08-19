package com.mobil.ws.application.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.aggregator.CustomerAggregator;
import com.mobil.ws.application.service.GenericService;
import com.mobil.ws.domain.customer.CustomerDto;

@Component
public class CustomerServiceImpl implements GenericService<CustomerDto> {

	Logger log = Logger.getLogger(CustomerServiceImpl.class);
	CustomerAggregator<CustomerDto> customerAggregator;

	@Autowired
	public CustomerServiceImpl(CustomerAggregator<CustomerDto> customerAggregator) throws SQLException {
		this.customerAggregator = customerAggregator;
	}

	@Override
	public void saveOrUpdate(CustomerDto request) throws SQLException {
		this.customerAggregator.saveOrUpdate(request);
	}

	@Override
	public List<CustomerDto> getAll() {
		log.info("EL TAMAÑO DE LA LISTA ES: " + customerAggregator.getAll().size());
		log.info("LEYENDO RESPUESTA.................");
		List<CustomerDto> listCustomer = customerAggregator.getAll();
		return listCustomer;
	}

	@Override
	public CustomerDto findId(Integer id) {
		return customerAggregator.findById(id);
	}

	@Override
	public void deleteRecord(CustomerDto t) {
		customerAggregator.deleteRecord(t);

	}

}
