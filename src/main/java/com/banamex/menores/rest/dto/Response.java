package com.banamex.menores.rest.dto;

public class Response {

	private String folio;
	private String curpMenor;
	private String curpTutor;
	private String curpMenorResultado;
	private String curpMenorDiagnostico;
	private String domicilioResultado;
	private String domicilioDiagnostico;

	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getCurpMenor() {
		return curpMenor;
	}
	public void setCurpMenor(String curpMenor) {
		this.curpMenor = curpMenor;
	}
	public String getCurpTutor() {
		return curpTutor;
	}
	public void setCurpTutor(String curpTutor) {
		this.curpTutor = curpTutor;
	}
	public String getCurpMenorResultado() {
		return curpMenorResultado;
	}
	public void setCurpMenorResultado(String curpMenorResultado) {
		this.curpMenorResultado = curpMenorResultado;
	}
	public String getCurpMenorDiagnostico() {
		return curpMenorDiagnostico;
	}
	public void setCurpMenorDiagnostico(String curpMenorDiagnostico) {
		this.curpMenorDiagnostico = curpMenorDiagnostico;
	}
	public String getDomicilioResultado() {
		return domicilioResultado;
	}
	public void setDomicilioResultado(String domicilioResultado) {
		this.domicilioResultado = domicilioResultado;
	}
	public String getDomicilioDiagnostico() {
		return domicilioDiagnostico;
	}
	public void setDomicilioDiagnostico(String domicilioDiagnostico) {
		this.domicilioDiagnostico = domicilioDiagnostico;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [folio=");
		builder.append(folio);
		builder.append(", curpMenor=");
		builder.append(curpMenor);
		builder.append(", curpTutor=");
		builder.append(curpTutor);
		builder.append(", curpMenorResultado=");
		builder.append(curpMenorResultado);
		builder.append(", curpMenorDiagnostico=");
		builder.append(curpMenorDiagnostico);
		builder.append(", domicilioResultado=");
		builder.append(domicilioResultado);
		builder.append(", domicilioDiagnostico=");
		builder.append(domicilioDiagnostico);
		builder.append("]");
		return builder.toString();
	}
	
	
}
