package com.banamex.menores.rest.dto;

import java.io.Serializable;

public class Cuerpo implements Serializable{

	/**
	 * Agregar el serializador E.M.S
	 */
	private static final long serialVersionUID = 1L;
	private String entidadOrigen;
	private String tipoMovimiento;
	private String curpMenorEdad;
    private DatosBaseCurpMenor datosBaseCurpMenor;
    private DatosDomParticular datosDomParticular;
	public String getEntidadOrigen() {
		return entidadOrigen;
	}
	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public String getCurpMenorEdad() {
		return curpMenorEdad;
	}
	public void setCurpMenorEdad(String curpMenorEdad) {
		this.curpMenorEdad = curpMenorEdad;
	}
	public DatosBaseCurpMenor getDatosBaseCurpMenor() {
		return datosBaseCurpMenor;
	}
	public void setDatosBaseCurpMenor(DatosBaseCurpMenor datosBaseCurpMenor) {
		this.datosBaseCurpMenor = datosBaseCurpMenor;
	}
	public DatosDomParticular getDatosDomParticular() {
		return datosDomParticular;
	}
	public void setDatosDomParticular(DatosDomParticular datosDomParticular) {
		this.datosDomParticular = datosDomParticular;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cuerpo [entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", tipoMovimiento=");
		builder.append(tipoMovimiento);
		builder.append(", curpMenorEdad=");
		builder.append(curpMenorEdad);
		builder.append(", datosBaseCurpMenor=");
		builder.append(datosBaseCurpMenor);
		builder.append(", datosDomParticular=");
		builder.append(datosDomParticular);
		builder.append("]");
		return builder.toString();
	}

    
	
	
    
}
