package com.banamex.menores.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DatosDomParticular {

	private String calle;
	@JsonInclude(Include.NON_EMPTY)
	private String numeroExterior;
	@JsonInclude(Include.NON_EMPTY)
	private String numeroInterior;
	private String colonia;
	private String delegacionMunicipio;
	private String codigoPostal;
	private String entidadFederativa;
	private String pais;
	private String indicadorTelefono1;
	private String telefono1;
	private String extension1;
	private String indicadorTelefono2;
	private String telefono2;
	@JsonInclude(Include.NON_EMPTY)
	private String extension2;
	@JsonInclude(Include.NON_EMPTY)
	private String correoElectronicoTutor;
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
	public String getIndicadorTelefono1() {
		return indicadorTelefono1;
	}
	public void setIndicadorTelefono1(String indicadorTelefono1) {
		this.indicadorTelefono1 = indicadorTelefono1;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosDomParticular [calle=");
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
		builder.append(", indicadorTelefono1=");
		builder.append(indicadorTelefono1);
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
		builder.append(", getCorreoElectronicoTutor()=");
		builder.append(getCorreoElectronicoTutor());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	

	
	
}
