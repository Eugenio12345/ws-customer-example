package com.mobil.ws.application.aggregator;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.repository.customer.CustomerRepository;
import com.mobil.ws.application.repository.file.FileRepository;
import com.mobil.ws.application.repository.ubication.UbicationRepository;
import com.mobil.ws.domain.customer.CustomerDto;
import com.mobil.ws.domain.file.Files;
import com.mobil.ws.domain.ubications.Ubication;

/**
 * 
 * @author RSTNMX0003
 *
 *         Clase encargada de obtener todos los repositorios
 *
 * @param <T>
 */

@Component
public class CustomerAggregator<T> {

	Logger logger = Logger.getLogger(CustomerAggregator.class);

	private CustomerRepository customerRepository;

	/**
	 * UbicationRepository ubicationRepository
	 */
	private UbicationRepository ubicationRepository;

	private FileRepository fileRepository;

	/**
	 * 
	 * @param customerRepository
	 * @param ubicationRepository
	 * @param fileRepository
	 */
	@Autowired
	public CustomerAggregator(CustomerRepository customerRepository, UbicationRepository ubicationRepository,
			FileRepository fileRepository) {
		this.customerRepository = customerRepository;
		this.fileRepository = fileRepository;
		this.ubicationRepository = ubicationRepository;
	}

	/**
	 * 
	 * @param object
	 * @throws SQLException
	 */
	public void saveOrUpdate(T object) throws SQLException {
		logger.info("Entrando a object...." + object.getClass());
		if (object instanceof CustomerDto) {
			this.customerRepository.save((CustomerDto) object);
		} else if (object instanceof Files) {
			this.fileRepository.save((Files) object);
		} else if (object instanceof Ubication) {
			this.ubicationRepository.save((Ubication) object);
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>) this.customerRepository.findAllCustomer();
	}

	@SuppressWarnings("unchecked")
	public T findById(Integer id) {
		return (T) this.customerRepository.findOne(id);
	}

	
	public void deleteRecord(T object){
		logger.info("Entrando a object...." + object.getClass());
		if (object instanceof CustomerDto) {
			this.customerRepository.delete((CustomerDto) object);
		} else if (object instanceof Files) {
			this.fileRepository.delete((Files) object);
		} else if (object instanceof Ubication) {
			this.ubicationRepository.delete((Ubication) object);
		}
	}
}