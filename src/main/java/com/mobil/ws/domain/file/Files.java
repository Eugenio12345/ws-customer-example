package com.mobil.ws.domain.file;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mobil.ws.domain.customer.Customer;

@Entity(name = "CT_FILES")
public class Files {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name  = "ID_ARCHIVO")
	private Integer idArchido;
	
	@Column(name = "FOTO_CABLEADO")
	private String fotoCableado;
	
	@Column(name = "FOTO_ANTENA")
	private String fotoAntena;
	
	@Column(name = "FOTO_ROUTER")
	private String fotoRouter;
	
	@Column(name = "FOTO_AUX")
	private String fotoAux;
	
	@Column(name = "FOTO_AUX2")
	private String fotoAux2;
	
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

	/**
	 * New Instance
	 */
	public Files(){
		
	}
	
	
	/**
	 * @param idArchido
	 * @param fotoCableado
	 * @param fotoAntena
	 * @param fotoRouter
	 * @param fotoAux
	 * @param fotoAux2
	 * @param customer
	 */
	public Files(Integer idArchido, String fotoCableado, String fotoAntena, String fotoRouter, String fotoAux,
			String fotoAux2, Customer customer) {
		super();
		this.idArchido = idArchido;
		this.fotoCableado = fotoCableado;
		this.fotoAntena = fotoAntena;
		this.fotoRouter = fotoRouter;
		this.fotoAux = fotoAux;
		this.fotoAux2 = fotoAux2;
		this.customer = customer;
	}
	
	
}
