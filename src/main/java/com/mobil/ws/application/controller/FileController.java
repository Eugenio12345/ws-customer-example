package com.mobil.ws.application.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobil.ws.application.service.GenericService;
import com.mobil.ws.domain.file.Files;

@Controller
@RequestMapping(value = "/api")
public class FileController {

	private GenericService<Files> genericService;
	
	@Autowired
	public FileController(GenericService<Files> genericService){
		this.genericService = genericService;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/v1/files/save")
    public ResponseEntity<Void>saveFile(@RequestBody Files files) throws SQLException{
		this.genericService.saveOrUpdate(files);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
