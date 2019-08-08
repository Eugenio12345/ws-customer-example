package com.mobil.ws.application.aggregator;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.repository.customer.CustomerRepository;
import com.mobil.ws.domain.customer.Customer;

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

	private CustomerRepository customerRepository;

	/**
	 * 
	 * @param customerRepository
	 * @param ubicationRepository
	 * @param fileRepository
	 */
	@Autowired
	public CustomerAggregator(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
		
	}

	/**
	 * 
	 * @param object
	 * @throws SQLException
	 */
	public void saveOrUpdate(T object) throws SQLException {
		if(object instanceof Customer){
		logger.info("Entrando a object...." + object.getClass());
		this.customerRepository.save((Customer)object);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T>getAll(){
		return (List<T>) this.customerRepository.findAllCustomer();
	}
	
	@SuppressWarnings("unchecked")
	public T findById(Integer id){
		return (T) this.customerRepository.findOne(id);
	}
	
}