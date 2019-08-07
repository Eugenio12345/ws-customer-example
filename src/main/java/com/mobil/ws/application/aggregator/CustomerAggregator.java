package com.mobil.ws.application.aggregator;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.repository.customer.CustomerRepository;

/**
 * 
 * @author RSTNMX0003
 *
 *  Clase encargada de obtener todos los repositorios
 *
 * @param <T>
 */

@Component
public class CustomerAggregator<T> {

	Logger logger = Logger.getLogger(CustomerAggregator.class);

	private CustomerRepository<T> customerRepository;

	/**
	 * 
	 * @param customerRepository
	 * @param ubicationRepository
	 * @param fileRepository
	 */
	@Autowired
	public CustomerAggregator(CustomerRepository<T> customerRepository) {
		this.customerRepository = customerRepository;
		
	}

	/**
	 * 
	 * @param object
	 * @throws SQLException
	 */
	public void saveOrUpdate(T object) throws SQLException {
		logger.info("Entrando a object...." + object.getClass());
		this.customerRepository.save(object);
	}
	
	public List<T>getAll(){
		return (List<T>) this.customerRepository.findAll();
	}
	
	public T findById(Integer id){
		return this.customerRepository.findOne(id);
	}
	
}