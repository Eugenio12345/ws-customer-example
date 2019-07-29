package com.mobil.ws.domain.ubications;

import javax.persistence.Entity;

@Entity
public class Ubication {

	private Integer idUbicacion;
	private double longitug;
	private double latitud;
	private Integer idCliente;

	public Integer getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public double getLongitug() {
		return longitug;
	}

	public void setLongitug(double longitug) {
		this.longitug = longitug;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
