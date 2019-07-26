package com.banamex.menores.rest.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banamex.menores.rest.component.BobTrMenores;
import com.banamex.menores.rest.dto.Request;
import com.banamex.menores.rest.dto.Response;
import com.banamex.menores.rest.dto.Respuesta;
import com.banamex.menores.rest.service.DatamartServ;
import com.banamex.menores.restClient.procesar.service.ResolucionService;
import com.google.gson.Gson;

@RestController
public class MenoresCtrl {

	@Autowired
	private DatamartServ datamartService;

	@Autowired
	private ResolucionService resolucionService;

	@RequestMapping(value = "/dservice/registraMenores", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> registraMenores(@RequestBody Request request) {
		HttpHeaders headers = new HttpHeaders();
		Respuesta respuesta = new Respuesta();
		if (request == null) {
			return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
		}
		String apellidoMaternoMenorEdad = request.getDatosBaseCurpMenor().getApellidoMaternoMenorEdad()==null ? "" 
				:request.getDatosBaseCurpMenor().getApellidoMaternoMenorEdad();

		request.getDatosBaseCurpMenor().setApellidoMaternoMenorEdad(
				(apellidoMaternoMenorEdad.equals("N/A") || apellidoMaternoMenorEdad.isEmpty()) ? null : apellidoMaternoMenorEdad);

		respuesta = resolucionService.registraMenor(request);

		BobTrMenores bobTrMenores = setBobTrMenores(request, respuesta);
		datamartService.saveResolucion(bobTrMenores);
		Response response = new Response();
		response.setFolio(request.getFolio());
		response.setCurpMenor(request.getCurpMenorEdad());
		response.setCurpTutor(request.getDatosBaseCurpMenor().getCurpTutor());

		if (respuesta != null && respuesta.getDatosBaseCurpMenor() != null) {
			response.setCurpMenorResultado(respuesta.getDatosBaseCurpMenor().getResultadoOperacion());
			response.setCurpMenorDiagnostico(respuesta.getDatosBaseCurpMenor().getDiagnosticoRecepcion());
		}
		if (respuesta != null && respuesta.getDatosDomParticular() != null) {
			response.setDomicilioResultado("");
			response.setDomicilioDiagnostico("");
		}

		headers.add("MenoresResponse Created  - ", String.valueOf(200));

		return new ResponseEntity<Response>(response, headers, HttpStatus.CREATED);
	}

	private BobTrMenores setBobTrMenores(Request request, Respuesta response) {
		BobTrMenores bobTrMenores = new BobTrMenores();

		Date fechaCreacion = new Date();

		bobTrMenores.setChFolio(request.getFolio());
		bobTrMenores.setCurpMenor(request.getCurpMenorEdad());
		bobTrMenores.setChSelloVerificacion(request.getDatosBaseCurpMenor().getSelloVerificacionBiometrica());
		bobTrMenores.setCurpTutor(request.getDatosBaseCurpMenor().getCurpTutor());
		bobTrMenores.setChCurpMenorResultado(response.getDatosBaseCurpMenor().getResultadoOperacion());

		if (response != null && response.getDatosBaseCurpMenor() != null
				&& response.getDatosBaseCurpMenor().getDiagnosticoRecepcion() != null
				&& response.getDatosBaseCurpMenor().getDiagnosticoRecepcion().length() > 0) {
			String diagnosticoRecepcion = String
					.format("%-15s", response.getDatosBaseCurpMenor().getDiagnosticoRecepcion()).replace(' ', '0');
			response.getDatosBaseCurpMenor().setDiagnosticoRecepcion(diagnosticoRecepcion);
		}
		bobTrMenores.setChCurpMenorDiagnostico(response.getDatosBaseCurpMenor().getDiagnosticoRecepcion());
		bobTrMenores.setChDomicilioResultado(response.getDatosDomParticular().getResultadoOperacion());

		if (response != null && response.getDatosDomParticular() != null
				&& response.getDatosDomParticular().getDiagnosticoRecepcion() != null
				&& response.getDatosDomParticular().getDiagnosticoRecepcion().length() > 0) {
			String diagnosticoRecepcion = String
					.format("%-15s", response.getDatosDomParticular().getDiagnosticoRecepcion()).replace(' ', '0');
			response.getDatosDomParticular().setDiagnosticoRecepcion(diagnosticoRecepcion);
		}
		bobTrMenores.setChDomicilioDiagnostico(response.getDatosDomParticular().getDiagnosticoRecepcion());
		Gson gson = new Gson();
		String jsonRequest = gson.toJson(request);
		String jsonResponse = gson.toJson(response);
		bobTrMenores.setChJsonRequest(jsonRequest);
		bobTrMenores.setChJsonResponse(jsonResponse);
		bobTrMenores.setFcCreacion(fechaCreacion);
		bobTrMenores.setFcModificacion(null);

		return bobTrMenores;
	}

}
