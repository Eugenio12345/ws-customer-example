package com.mobil.ws.domain.customer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mobil.ws.domain.file.Files;
import com.mobil.ws.domain.ubications.Ubication;

@Table(name = "CT_CUSTOMER")
@Entity
@NamedQuery(name = "Customer.findAllCustomer", query = "from Customer c inner join  c.listFiles inner join c.listUbications")
public class Customer {

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

	@JsonBackReference
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Files> listFiles;

	@JsonBackReference
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Ubication> listUbications;

	/**
	 * @return the listFiles
	 */
	public List<Files> getListFiles() {
		return listFiles;
	}

	/**
	 * @param listFiles
	 *            the listFiles to set
	 */
	public void setListFiles(List<Files> listFiles) {
		this.listFiles = listFiles;
	}

	/**
	 * @return the listUbications
	 */
	public List<Ubication> getListUbications() {
		return listUbications;
	}

	/**
	 * @param listUbications
	 *            the listUbications to set
	 */
	public void setListUbications(List<Ubication> listUbications) {
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
			String telefono, String serialRouter, String serialAntena, List<Files> listFiles,
			List<Ubication> listUbications) {
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
