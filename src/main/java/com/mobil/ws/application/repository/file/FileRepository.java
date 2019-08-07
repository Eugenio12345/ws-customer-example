package com.mobil.ws.application.repository.file;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobil.ws.domain.file.Files;

@Repository
public interface FileRepository extends CrudRepository<Files, Integer>{

	
}
