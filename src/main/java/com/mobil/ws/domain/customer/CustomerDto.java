package com.mobil.ws.domain.customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mobil.ws.domain.file.Files;
import com.mobil.ws.domain.ubications.Ubication;

@Table(name = "CT_CUSTOMER")
@Entity
@NamedQuery(name = "CustomerDto.findAllCustomer", query = "from CustomerDto as customer join customer.files as files inner join customer.ubication as ubication")
public class CustomerDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CLIENTE")
	private Integer idCliente;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO_MATERNO")
	private String apellidoMaterno;

	@Column(name = "APELLIDO_PATERNO")
	private String apellidoPaterno;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "SERIAL_ROUTER")
	private String serialRouter;

	@Column(name = "SERIAL_ANTENA")
	private String serialAntena;

	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Files files;

	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Ubication ubication;

	
	/**
	 * @return the files
	 */
	public Files getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(Files files) {
		this.files = files;
	}

	/**
	 * @return the ubication
	 */
	public Ubication getUbication() {
		return ubication;
	}

	/**
	 * @param ubication the ubication to set
	 */
	public void setUbication(Ubication ubication) {
		this.ubication = ubication;
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
	public CustomerDto() {

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
	 * @param files
	 * @param ubication
	 */
	public CustomerDto(Integer idCliente, String nombre, String apellidoMaterno, String apellidoPaterno,
			String direccion, String telefono, String serialRouter, String serialAntena, Files files,
			Ubication ubication) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.serialRouter = serialRouter;
		this.serialAntena = serialAntena;
		this.files = files;
		this.ubication = ubication;
	}	
}
