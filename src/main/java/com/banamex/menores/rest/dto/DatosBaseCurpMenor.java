package com.banamex.menores.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DatosBaseCurpMenor {

	@JsonInclude(Include.NON_EMPTY)
	private String curpNuevaMenorEdad;
	@JsonInclude(Include.NON_EMPTY)
	private String rfcMenorEdad;
	private String apellidoPaternoMenorEdad;
	//Agregar la anotacion para que ignores los campos cuando vengan nulos
	@JsonInclude(Include.NON_EMPTY)
	private String apellidoMaternoMenorEdad;
	private String nombreMenorEdad;
	private String fechaNacimientoMenorEdad;
	private Integer sexoMenorEdad;
	private String entidadNacimientoMenorEdad;
	@JsonInclude(Include.NON_EMPTY)
	private String nacionalidadMenorEdad;
	@JsonInclude(Include.NON_EMPTY)
	private String claveTipoDocumentoProbatorioMenorEdad;
         
	private String folioSolicitudMenorEdad;
	@JsonInclude(Include.NON_EMPTY)
	private String documentoProbatorioMenorEdad;
	@JsonInclude(Include.NON_EMPTY)
	private String folioDocumentoProbatorioMenorEdad;
	private String selloVerificacionBiometrica;
	private String curpTutor;
	public String getCurpNuevaMenorEdad() {
		return curpNuevaMenorEdad;
	}
	public void setCurpNuevaMenorEdad(String curpNuevaMenorEdad) {
		this.curpNuevaMenorEdad = curpNuevaMenorEdad;
	}
	public String getRfcMenorEdad() {
		return rfcMenorEdad;
	}
	public void setRfcMenorEdad(String rfcMenorEdad) {
		this.rfcMenorEdad = rfcMenorEdad;
	}
	public String getApellidoPaternoMenorEdad() {
		return apellidoPaternoMenorEdad;
	}
	public void setApellidoPaternoMenorEdad(String apellidoPaternoMenorEdad) {
		this.apellidoPaternoMenorEdad = apellidoPaternoMenorEdad;
	}
	public String getApellidoMaternoMenorEdad() {
		return apellidoMaternoMenorEdad;
	}
	public void setApellidoMaternoMenorEdad(String apellidoMaternoMenorEdad) {
		this.apellidoMaternoMenorEdad = apellidoMaternoMenorEdad;
	}
	public String getNombreMenorEdad() {
		return nombreMenorEdad;
	}
	public void setNombreMenorEdad(String nombreMenorEdad) {
		this.nombreMenorEdad = nombreMenorEdad;
	}
	public String getFechaNacimientoMenorEdad() {
		return fechaNacimientoMenorEdad;
	}
	public void setFechaNacimientoMenorEdad(String fechaNacimientoMenorEdad) {
		this.fechaNacimientoMenorEdad = fechaNacimientoMenorEdad;
	}
	public Integer getSexoMenorEdad() {
		return sexoMenorEdad;
	}
	public void setSexoMenorEdad(Integer sexoMenorEdad) {
		this.sexoMenorEdad = sexoMenorEdad;
	}
	public String getEntidadNacimientoMenorEdad() {
		return entidadNacimientoMenorEdad;
	}
	public void setEntidadNacimientoMenorEdad(String entidadNacimientoMenorEdad) {
		this.entidadNacimientoMenorEdad = entidadNacimientoMenorEdad;
	}
	public String getNacionalidadMenorEdad() {
		return nacionalidadMenorEdad;
	}
	public void setNacionalidadMenorEdad(String nacionalidadMenorEdad) {
		this.nacionalidadMenorEdad = nacionalidadMenorEdad;
	}
	public String getClaveTipoDocumentoProbatorioMenorEdad() {
		return claveTipoDocumentoProbatorioMenorEdad;
	}
	public void setClaveTipoDocumentoProbatorioMenorEdad(
			String claveTipoDocumentoProbatorioMenorEdad) {
		this.claveTipoDocumentoProbatorioMenorEdad = claveTipoDocumentoProbatorioMenorEdad;
	}
	public String getFolioSolicitudMenorEdad() {
		return folioSolicitudMenorEdad;
	}
	public void setFolioSolicitudMenorEdad(String folioSolicitudMenorEdad) {
		this.folioSolicitudMenorEdad = folioSolicitudMenorEdad;
	}
	public String getDocumentoProbatorioMenorEdad() {
		return documentoProbatorioMenorEdad;
	}
	public void setDocumentoProbatorioMenorEdad(String documentoProbatorioMenorEdad) {
		this.documentoProbatorioMenorEdad = documentoProbatorioMenorEdad;
	}
	public String getFolioDocumentoProbatorioMenorEdad() {
		return folioDocumentoProbatorioMenorEdad;
	}
	public void setFolioDocumentoProbatorioMenorEdad(
			String folioDocumentoProbatorioMenorEdad) {
		this.folioDocumentoProbatorioMenorEdad = folioDocumentoProbatorioMenorEdad;
	}
	public String getSelloVerificacionBiometrica() {
		return selloVerificacionBiometrica;
	}
	public void setSelloVerificacionBiometrica(String selloVerificacionBiometrica) {
		this.selloVerificacionBiometrica = selloVerificacionBiometrica;
	}
	public String getCurpTutor() {
		return curpTutor;
	}
	public void setCurpTutor(String curpTutor) {
		this.curpTutor = curpTutor;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosBaseCurpMenor [curpNuevaMenorEdad=");
		builder.append(curpNuevaMenorEdad);
		builder.append(", rfcMenorEdad=");
		builder.append(rfcMenorEdad);
		builder.append(", apellidoPaternoMenorEdad=");
		builder.append(apellidoPaternoMenorEdad);
		builder.append(", apellidoMaternoMenorEdad=");
		builder.append(apellidoMaternoMenorEdad);
		builder.append(", nombreMenorEdad=");
		builder.append(nombreMenorEdad);
		builder.append(", fechaNacimientoMenorEdad=");
		builder.append(fechaNacimientoMenorEdad);
		builder.append(", sexoMenorEdad=");
		builder.append(sexoMenorEdad);
		builder.append(", entidadNacimientoMenorEdad=");
		builder.append(entidadNacimientoMenorEdad);
		builder.append(", nacionalidadMenorEdad=");
		builder.append(nacionalidadMenorEdad);
		builder.append(", claveTipoDocumentoProbatorioMenorEdad=");
		builder.append(claveTipoDocumentoProbatorioMenorEdad);
		builder.append(", folioSolicitudMenorEdad=");
		builder.append(folioSolicitudMenorEdad);
		builder.append(", documentoProbatorioMenorEdad=");
		builder.append(documentoProbatorioMenorEdad);
		builder.append(", folioDocumentoProbatorioMenorEdad=");
		builder.append(folioDocumentoProbatorioMenorEdad);
		builder.append(", selloVerificacionBiometrica=");
		builder.append(selloVerificacionBiometrica);
		builder.append(", curpTutor=");
		builder.append(curpTutor);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
