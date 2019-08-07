package com.mobil.ws.domain.ubications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mobil.ws.domain.customer.Customer;

@Entity(name = "CT_UBICATION")
public class Ubication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUbicacion;
	@Column
	private double longitug;
	private double latitud;

	@ManyToOne
	private Customer customer;

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

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

}
