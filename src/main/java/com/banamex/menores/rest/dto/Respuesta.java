package com.banamex.menores.rest.dto;

public class Respuesta {

	private String entidadOrigen;
	private String tipoDeMovimiento;
	private String curpMenorEdad;
	private RespDatosBaseCurpMenor datosBaseCurpMenor;
	private RespDatosDomParticular datosDomParticular;
	public String getEntidadOrigen() {
		return entidadOrigen;
	}
	public void setEntidadOrigen(String entidadOrigen) {
		this.entidadOrigen = entidadOrigen;
	}
	public String getTipoDeMovimiento() {
		return tipoDeMovimiento;
	}
	public void setTipoDeMovimiento(String tipoDeMovimiento) {
		this.tipoDeMovimiento = tipoDeMovimiento;
	}
	public String getCurpMenorEdad() {
		return curpMenorEdad;
	}
	public void setCurpMenorEdad(String curpMenorEdad) {
		this.curpMenorEdad = curpMenorEdad;
	}
	public RespDatosBaseCurpMenor getDatosBaseCurpMenor() {
		return datosBaseCurpMenor;
	}
	public void setDatosBaseCurpMenor(RespDatosBaseCurpMenor datosBaseCurpMenor) {
		this.datosBaseCurpMenor = datosBaseCurpMenor;
	}
	public RespDatosDomParticular getDatosDomParticular() {
		return datosDomParticular;
	}
	public void setDatosDomParticular(RespDatosDomParticular datosDomParticular) {
		this.datosDomParticular = datosDomParticular;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Respuesta [entidadOrigen=");
		builder.append(entidadOrigen);
		builder.append(", tipoDeMovimiento=");
		builder.append(tipoDeMovimiento);
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
