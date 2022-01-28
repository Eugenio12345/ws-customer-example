package com.mobil.ws.application.model;

import java.util.Set;

import com.mobil.ws.domain.file.Files;
import com.mobil.ws.domain.ubications.Ubication;

public class Customer {

	
	private Integer idCliente;

	private String nombre;

	private String apellidoMaterno;

	private String apellidoPaterno;

	private String direccion;

	private String telefono;

	private String serialRouter;

	private String serialAntena;

	
	private Set<Files> listFiles;

	
	private Set<Ubication> listUbications;

	/**
	 * @return the listFiles
	 */
	public Set<Files> getListFiles() {
		return listFiles;
	}

	/**
	 * @param listFiles
	 *            the listFiles to set
	 */
	public void setListFiles(Set<Files> listFiles) {
		this.listFiles = listFiles;
	}

	/**
	 * @return the listUbications
	 */
	public Set<Ubication> getListUbications() {
		return listUbications;
	}

	/**
	 * @param listUbications
	 *            the listUbications to set
	 */
	public void setListUbications(Set<Ubication> listUbications) {
		this.listUbications = listUbications;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSerialRouter() {
		return serialRouter;
	}

	public void setSerialRouter(String serialRouter) {
		this.serialRouter = serialRouter;
	}

	public String getSerialAntena() {
		return serialAntena;
	}

	public void setSerialAntena(String serialAntena) {
		this.serialAntena = serialAntena;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerRequest [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidoMaterno=" + apellidoMaterno
				+ ", apellidoPaterno=" + apellidoPaterno + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", serialRouter=" + serialRouter + ", serialAntena=" + serialAntena + "]";
	}

	/**
	 * New Instance
	 */
	public Customer() {

	}

	/**
	 * @param idCliente
	 * @param nombre
	 * @param apellidoMaterno
	 * @param apellidoPaterno
	 * @param direccion
	 * @param telefono
	 * @param serialRouter
	 * @param serialAntena
	 * @param listFiles
	 * @param listUbications
	 */
	public Customer(Integer idCliente, String nombre, String apellidoMaterno, String apellidoPaterno, String direccion,
			String telefono, String serialRouter, String serialAntena, Set<Files> listFiles,
			Set<Ubication> listUbications) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.serialRouter = serialRouter;
		this.serialAntena = serialAntena;
		this.listFiles = listFiles;
		this.listUbications = listUbications;
	}

	
	
}
