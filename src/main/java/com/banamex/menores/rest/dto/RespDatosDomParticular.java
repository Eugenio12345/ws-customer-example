package com.banamex.menores.rest.dto;

public class RespDatosDomParticular {

	private String calle;
	private String numeroExterior;
	private String numeroInterior;
	private String colonia;
	private String delegacionMunicipio;
	private String codigoPostal;
	private String entidadFederativa;
	private String pais;
	private String indicadorDeTelefono1;
	private String telefono1;
	private String extension1;
	private String indicadorTelefono2;
	private String telefono2;
	private String extension2;
	private String correoElectronicoTutor;
	private String resultadoOperacion;
	private String diagnosticoRecepcion;
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getEntidadFederativa() {
		return entidadFederativa;
	}
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getIndicadorDeTelefono1() {
		return indicadorDeTelefono1;
	}
	public void setIndicadorDeTelefono1(String indicadorDeTelefono1) {
		this.indicadorDeTelefono1 = indicadorDeTelefono1;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getExtension1() {
		return extension1;
	}
	public void setExtension1(String extension1) {
		this.extension1 = extension1;
	}
	public String getIndicadorTelefono2() {
		return indicadorTelefono2;
	}
	public void setIndicadorTelefono2(String indicadorTelefono2) {
		this.indicadorTelefono2 = indicadorTelefono2;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getExtension2() {
		return extension2;
	}
	public void setExtension2(String extension2) {
		this.extension2 = extension2;
	}
	public String getCorreoElectronicoTutor() {
		return correoElectronicoTutor;
	}
	public void setCorreoElectronicoTutor(String correoElectronicoTutor) {
		this.correoElectronicoTutor = correoElectronicoTutor;
	}
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}
	public String getDiagnosticoRecepcion() {
		return diagnosticoRecepcion;
	}
	public void setDiagnosticoRecepcion(String diagnosticoRecepcion) {
		this.diagnosticoRecepcion = diagnosticoRecepcion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RespDatosDomParticular [calle=");
		builder.append(calle);
		builder.append(", numeroExterior=");
		builder.append(numeroExterior);
		builder.append(", numeroInterior=");
		builder.append(numeroInterior);
		builder.append(", colonia=");
		builder.append(colonia);
		builder.append(", delegacionMunicipio=");
		builder.append(delegacionMunicipio);
		builder.append(", codigoPostal=");
		builder.append(codigoPostal);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", pais=");
		builder.append(pais);
		builder.append(", indicadorDeTelefono1=");
		builder.append(indicadorDeTelefono1);
		builder.append(", telefono1=");
		builder.append(telefono1);
		builder.append(", extension1=");
		builder.append(extension1);
		builder.append(", indicadorTelefono2=");
		builder.append(indicadorTelefono2);
		builder.append(", telefono2=");
		builder.append(telefono2);
		builder.append(", extension2=");
		builder.append(extension2);
		builder.append(", correoElectronicoTutor=");
		builder.append(correoElectronicoTutor);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", diagnosticoRecepcion=");
		builder.append(diagnosticoRecepcion);
		builder.append("]");
		return builder.toString();
	}
	
	
}
