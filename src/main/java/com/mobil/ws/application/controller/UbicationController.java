package com.mobil.ws.application.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobil.ws.application.service.GenericService;
import com.mobil.ws.domain.ubications.Ubication;

@Controller
@RequestMapping(value = "/api")
public class UbicationController {

	private GenericService<Ubication>genericService;
	
	public UbicationController(GenericService<Ubication>genericService){
		this.genericService = genericService;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/ubication/save")
	public ResponseEntity<Void>saveUbication(@RequestBody Ubication ubication) throws SQLException{
		this.genericService.saveOrUpdate(ubication);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
