package com.mobil.ws.application.repository.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository<T> extends CrudRepository<T, Integer>{

	  List<T> findByNombre(String nombre);
}
