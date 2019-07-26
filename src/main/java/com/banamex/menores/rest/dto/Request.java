package com.banamex.menores.rest.dto;

public class Request extends Cuerpo {

	/**
	 * Agregar el serializador E.M.S
	 */
	private static final long serialVersionUID = 1L;
	
	private String folio;

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Request [folio=");
		builder.append(folio);
		builder.append(", entidadOrigen=");
		builder.append(this.getEntidadOrigen());
		builder.append(", tipoMovimiento=");
		builder.append(this.getTipoMovimiento());
		builder.append(", curpMenorEdad=");
		builder.append(this.getCurpMenorEdad());
		builder.append(", datosBaseCurpMenor=");
		builder.append(this.getDatosBaseCurpMenor());
		builder.append(", datosDomParticular=");
		builder.append(this.getDatosDomParticular());
		builder.append("]");
		return builder.toString();
	}

}
