package com.banamex.menores.restClient.procesar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.banamex.menores.rest.dto.Cuerpo;
import com.banamex.menores.rest.dto.Respuesta;
import com.banamex.menores.restClient.procesar.menores.ProcesarMenoresRestConnectorImpl;

@Service
public class ResolucionService{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ResolucionService.class);


	// private static final String DATAMART_URL =
	// "https://192.168.1.61/retiros/v1/resoluciones/busquedaPorInstituto";

	public Respuesta registraMenor(Cuerpo cuerpo) {
		Respuesta response = null;
		
		ProcesarMenoresRestConnectorImpl procesarMenoresRestConnectorImpl =
				new ProcesarMenoresRestConnectorImpl();
				
		response = procesarMenoresRestConnectorImpl.registraMenor(cuerpo);
								
		return response;
	}
	
}
