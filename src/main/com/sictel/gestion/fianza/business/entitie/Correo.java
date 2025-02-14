/**
 * 
 */
package com.sictel.gestion.fianza.business.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
@Entity
@Table(name = "correo")
public class Correo {

	@Id
	@Column(name = "`correoId`")
	private String correoId;

	@Column(name = "`correoDetalleId`")
	private String correoDetalleId;

	@Column(name = "`correoAsunto`")
	private String correoAsunto;

	@Column(name = "`correoTexto`")
	private String correoTexto;

	@JoinColumn(name = "`correoDetalleId`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private CorreoDetalle correoDetalle;

	/**
	 * @return the correoId
	 */
	public String getCorreoId() {
		return correoId;
	}

	/**
	 * @param correoId the correoId to set
	 */
	public void setCorreoId(String correoId) {
		this.correoId = correoId;
	}

	/**
	 * @return the correoDetalleId
	 */
	public String getCorreoDetalleId() {
		return correoDetalleId;
	}

	/**
	 * @param correoDetalleId the correoDetalleId to set
	 */
	public void setCorreoDetalleId(String correoDetalleId) {
		this.correoDetalleId = correoDetalleId;
	}

	/**
	 * @return the correoAsunto
	 */
	public String getCorreoAsunto() {
		return correoAsunto;
	}

	/**
	 * @param correoAsunto the correoAsunto to set
	 */
	public void setCorreoAsunto(String correoAsunto) {
		this.correoAsunto = correoAsunto;
	}

	/**
	 * @return the correoTexto
	 */
	public String getCorreoTexto() {
		return correoTexto;
	}

	/**
	 * @param correoTexto the correoTexto to set
	 */
	public void setCorreoTexto(String correoTexto) {
		this.correoTexto = correoTexto;
	}

	/**
	 * @return the correoDetalle
	 */
	public CorreoDetalle getCorreoDetalle() {
		return correoDetalle;
	}

	/**
	 * @param correoDetalle the correoDetalle to set
	 */
	public void setCorreoDetalle(CorreoDetalle correoDetalle) {
		this.correoDetalle = correoDetalle;
	}

}
