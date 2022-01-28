package com.mobil.ws.application.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobil.ws.application.aggregator.CustomerAggregator;
import com.mobil.ws.application.service.GenericService;
import com.mobil.ws.domain.ubications.Ubication;

@Service
public class UbicationServiceImpl implements GenericService<Ubication>{

	CustomerAggregator<Ubication>customerAggregator;
	
	@Autowired
	public UbicationServiceImpl(CustomerAggregator<Ubication>customerAggregator){
		this.customerAggregator = customerAggregator;
	}
	
	@Override
	public void saveOrUpdate(Ubication t) throws SQLException {
		this.customerAggregator.saveOrUpdate(t);
	}

	@Override
	public List<Ubication> getAll() {
		return this.customerAggregator.getAll();
	}

	@Override
	public Ubication findId(Integer id) {
		return this.customerAggregator.findById(id);
	}

	@Override
	public void deleteRecord(Ubication t) {
		this.customerAggregator.deleteRecord(t);
		
	}

}
