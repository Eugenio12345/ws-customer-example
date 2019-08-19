package com.mobil.ws.application.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobil.ws.application.aggregator.CustomerAggregator;
import com.mobil.ws.application.service.GenericService;
import com.mobil.ws.domain.file.Files;

@Service
public class FileServiceImpl implements GenericService<Files> {

	CustomerAggregator<Files> customerAggregator;
	
	@Autowired
	public FileServiceImpl(CustomerAggregator<Files> customerAggregator){
		this.customerAggregator = customerAggregator;
	}
	
	
	@Override
	public void saveOrUpdate(Files t) throws SQLException {
		this.customerAggregator.saveOrUpdate(t);		
	}

	@Override
	public List<Files> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Files findId(Integer id) {
		// TODO Auto-generated method stub
		return this.customerAggregator.findById(id);
	}

	@Override
	public void deleteRecord(Files t) {
		this.customerAggregator.deleteRecord(t);	
	}

}
