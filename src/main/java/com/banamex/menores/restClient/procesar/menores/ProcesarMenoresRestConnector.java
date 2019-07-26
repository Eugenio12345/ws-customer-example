package com.banamex.menores.restClient.procesar.menores;

import com.banamex.menores.rest.dto.Cuerpo;
import com.banamex.menores.rest.dto.Respuesta;



public interface ProcesarMenoresRestConnector{

	Respuesta registraMenor(Cuerpo requestDto);

}
