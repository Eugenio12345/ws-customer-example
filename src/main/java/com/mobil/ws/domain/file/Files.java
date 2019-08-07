package com.mobil.ws.domain.file;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mobil.ws.domain.customer.Customer;

@Entity(name = "CT_FILES")
public class Files {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idArchido;
	
	private String fotoCableado;
	private String fotoAntena;
	private String fotoRouter;
	private String fotoAux;
	private String fotoAux2;
	
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
	
	public Integer getIdArchido() {
		return idArchido;
	}
	public void setIdArchido(Integer idArchido) {
		this.idArchido = idArchido;
	}
	public String getFotoCableado() {
		return fotoCableado;
	}
	public void setFotoCableado(String fotoCableado) {
		this.fotoCableado = fotoCableado;
	}
	public String getFotoAntena() {
		return fotoAntena;
	}
	public void setFotoAntena(String fotoAntena) {
		this.fotoAntena = fotoAntena;
	}
	public String getFotoRouter() {
		return fotoRouter;
	}
	public void setFotoRouter(String fotoRouter) {
		this.fotoRouter = fotoRouter;
	}
	public String getFotoAux() {
		return fotoAux;
	}
	public void setFotoAux(String fotoAux) {
		this.fotoAux = fotoAux;
	}
	public String getFotoAux2() {
		return fotoAux2;
	}
	public void setFotoAux2(String fotoAux2) {
		this.fotoAux2 = fotoAux2;
	}
	
}
