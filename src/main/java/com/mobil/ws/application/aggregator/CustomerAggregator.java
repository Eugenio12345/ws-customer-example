package com.mobil.ws.application.aggregator;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobil.ws.application.repository.customer.CustomerRepository;
import com.mobil.ws.application.repository.file.FileRepository;
import com.mobil.ws.application.repository.ubication.UbicationRepository;
import com.mobil.ws.domain.customer.CustomerRequest;
import com.mobil.ws.domain.file.Files;
import com.mobil.ws.domain.ubications.Ubication;

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
		this.ubicationRepository = ubicationRepository;
		this.fileRepository = fileRepository;
	}

	/**
	 * 
	 * @param object
	 * @throws SQLException
	 */
	public void saveObject(T object) throws SQLException {

		if (object instanceof CustomerRequest) {
			logger.info("Entrando a object...." + object.getClass());
			this.customerRepository.save((CustomerRequest) object);
		} else if (object instanceof Ubication) {
			logger.info("Entrando a ");
			this.ubicationRepository.save((Ubication) object);
		} else if (object instanceof Files) {
			logger.info("Entrando a ...-----" + object);
			this.fileRepository.save((Files) object);
		}
	}
}
