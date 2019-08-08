package com.mobil.ws.domain.ubications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mobil.ws.domain.customer.Customer;

@Entity(name = "CT_UBICATION")
public class Ubication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_UBICACION")
	private Integer idUbicacion;
	
	@Column(name = "LONGITUD")
	private double longitug;
	
	@Column(name = "LATITUD")
	private double latitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE")
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

	/**
	 * New instance
	 */
	public Ubication(){
		
	}

	/**
	 * @param idUbicacion
	 * @param longitug
	 * @param latitud
	 * @param customer
	 */
	public Ubication(Integer idUbicacion, double longitug, double latitud, Customer customer) {
		super();
		this.idUbicacion = idUbicacion;
		this.longitug = longitug;
		this.latitud = latitud;
		this.customer = customer;
	}
	
	
}
