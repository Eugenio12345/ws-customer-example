package com.mobil.ws.domain.file;

import javax.persistence.Entity;

@Entity
public class Files {

	
	private Integer idArchido;
	private String fotoCableado;
	private String fotoAntena;
	private String fotoRouter;
	private String fotoAux;
	private String fotoAux2;
	private Integer idCliente;
	
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
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
}
