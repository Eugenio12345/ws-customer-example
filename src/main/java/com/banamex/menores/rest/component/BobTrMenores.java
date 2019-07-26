package com.banamex.menores.rest.component;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOB_TR_MENORES")
public class BobTrMenores implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SequenceIdMenores", sequenceName = "BOB_SEQ_MENORES", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdMenores")
	private Integer id;
	@Column(name = "CH_FOLIO")
	private String chFolio;
	@Column(name = "CURP_MENOR")
	private String curpMenor;
	@Column(name = "CH_SELLO_VERIFICACION")
	private String chSelloVerificacion;
	@Column(name = "CURP_TUTOR")
	private String curpTutor;
	@Column(name = "CH_CURP_MENOR_RESULTADO")
	private String chCurpMenorResultado;
	@Column(name = "CH_CURP_MENOR_DIAGNOSTICO")
	private String chCurpMenorDiagnostico;
	@Column(name = "CH_DOMICILIO_RESULTADO")
	private String chDomicilioResultado;
	@Column(name = "CH_DOMICILIO_DIAGNOSTICO")
	private String chDomicilioDiagnostico;
	@Column(name = "CH_JSON_REQUEST")
	private String chJsonRequest;
	@Column(name = "CH_JSON_RESPONSE")
	private String chJsonResponse;
	@Column(name = "FC_CREACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcCreacion;
	@Column(name = "FC_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcModificacion;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChFolio() {
		return chFolio;
	}
	public void setChFolio(String chFolio) {
		this.chFolio = chFolio;
	}
	public String getCurpMenor() {
		return curpMenor;
	}
	public void setCurpMenor(String curpMenor) {
		this.curpMenor = curpMenor;
	}
	public String getChSelloVerificacion() {
		return chSelloVerificacion;
	}
	public void setChSelloVerificacion(String chSelloVerificacion) {
		this.chSelloVerificacion = chSelloVerificacion;
	}
	public String getCurpTutor() {
		return curpTutor;
	}
	public void setCurpTutor(String curpTutor) {
		this.curpTutor = curpTutor;
	}
	public String getChCurpMenorResultado() {
		return chCurpMenorResultado;
	}
	public void setChCurpMenorResultado(String chCurpMenorResultado) {
		this.chCurpMenorResultado = chCurpMenorResultado;
	}
	public String getChCurpMenorDiagnostico() {
		return chCurpMenorDiagnostico;
	}
	public void setChCurpMenorDiagnostico(String chCurpMenorDiagnostico) {
		this.chCurpMenorDiagnostico = chCurpMenorDiagnostico;
	}
	public String getChDomicilioResultado() {
		return chDomicilioResultado;
	}
	public void setChDomicilioResultado(String chDomicilioResultado) {
		this.chDomicilioResultado = chDomicilioResultado;
	}
	public String getChDomicilioDiagnostico() {
		return chDomicilioDiagnostico;
	}
	public void setChDomicilioDiagnostico(String chDomicilioDiagnostico) {
		this.chDomicilioDiagnostico = chDomicilioDiagnostico;
	}
	public String getChJsonRequest() {
		return chJsonRequest;
	}
	public void setChJsonRequest(String chJsonRequest) {
		this.chJsonRequest = chJsonRequest;
	}
	public String getChJsonResponse() {
		return chJsonResponse;
	}
	public void setChJsonResponse(String chJsonResponse) {
		this.chJsonResponse = chJsonResponse;
	}
	public Date getFcCreacion() {
		return fcCreacion;
	}
	public void setFcCreacion(Date fcCreacion) {
		this.fcCreacion = fcCreacion;
	}
	public Date getFcModificacion() {
		return fcModificacion;
	}
	public void setFcModificacion(Date fcModificacion) {
		this.fcModificacion = fcModificacion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BobTrMenores [id=");
		builder.append(id);
		builder.append(", chFolio=");
		builder.append(chFolio);
		builder.append(", curpMenor=");
		builder.append(curpMenor);
		builder.append(", chSelloVerificacion=");
		builder.append(chSelloVerificacion);
		builder.append(", curpTutor=");
		builder.append(curpTutor);
		builder.append(", chCurpMenorResultado=");
		builder.append(chCurpMenorResultado);
		builder.append(", chCurpMenorDiagnostico=");
		builder.append(chCurpMenorDiagnostico);
		builder.append(", chDomicilioResultado=");
		builder.append(chDomicilioResultado);
		builder.append(", chDomicilioDiagnostico=");
		builder.append(chDomicilioDiagnostico);
		builder.append(", chJsonRequest=");
		builder.append(chJsonRequest);
		builder.append(", chJsonResponse=");
		builder.append(chJsonResponse);
		builder.append(", fcCreacion=");
		builder.append(fcCreacion);
		builder.append(", fcModificacion=");
		builder.append(fcModificacion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 41 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BobTrMenores other = (BobTrMenores) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
	
}
