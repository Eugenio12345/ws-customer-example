package com.mobil.ws.application.repository.ubication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobil.ws.domain.ubications.Ubication;

@Repository
public interface UbicationRepository extends CrudRepository<Ubication, Integer>{

	
}
