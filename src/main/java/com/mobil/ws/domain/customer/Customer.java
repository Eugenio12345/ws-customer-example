package com.mobil.ws.domain.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CT_CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCliente;
	
	private String nombre;

	private String apellidoMaterno;
	private String apellidoPaterno;
	private String direccion;
	private String telefono;
	private String serialRouter;
	private String serialAntena;

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
}
