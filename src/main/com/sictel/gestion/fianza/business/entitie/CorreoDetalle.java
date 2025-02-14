/**
 * 
 */
package com.sictel.gestion.fianza.business.entitie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
@Entity
@Table(name = "correo_detalle")
public class CorreoDetalle {

	@Id
	@Column(name = "`correoDetalleId`")
	private String correoDetalleId;

	@Column(name = "`correoDetalleCabecera`")
	private String correoDetalleCabecera;

	@Column(name = "`correoDetalleElem01`")
	private String correoDetalleElem01;

	@Column(name = "`correoDetalleElem02`")
	private String correoDetalleElem02;

	@Column(name = "`correoDetallePiePag`")
	private String correoDetallePiePag;

	@Column(name = "`correoDetalleAttach`")
	private String correoDetalleAttach;

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
	 * @return the correoDetalleCabecera
	 */
	public String getCorreoDetalleCabecera() {
		return correoDetalleCabecera;
	}

	/**
	 * @param correoDetalleCabecera the correoDetalleCabecera to set
	 */
	public void setCorreoDetalleCabecera(String correoDetalleCabecera) {
		this.correoDetalleCabecera = correoDetalleCabecera;
	}

	/**
	 * @return the correoDetalleElem01
	 */
	public String getCorreoDetalleElem01() {
		return correoDetalleElem01;
	}

	/**
	 * @param correoDetalleElem01 the correoDetalleElem01 to set
	 */
	public void setCorreoDetalleElem01(String correoDetalleElem01) {
		this.correoDetalleElem01 = correoDetalleElem01;
	}

	/**
	 * @return the correoDetalleElem02
	 */
	public String getCorreoDetalleElem02() {
		return correoDetalleElem02;
	}

	/**
	 * @param correoDetalleElem02 the correoDetalleElem02 to set
	 */
	public void setCorreoDetalleElem02(String correoDetalleElem02) {
		this.correoDetalleElem02 = correoDetalleElem02;
	}

	/**
	 * @return the correoDetallePiePag
	 */
	public String getCorreoDetallePiePag() {
		return correoDetallePiePag;
	}

	/**
	 * @param correoDetallePiePag the correoDetallePiePag to set
	 */
	public void setCorreoDetallePiePag(String correoDetallePiePag) {
		this.correoDetallePiePag = correoDetallePiePag;
	}

	/**
	 * @return the correoDetalleAttach
	 */
	public String getCorreoDetalleAttach() {
		return correoDetalleAttach;
	}

	/**
	 * @param correoDetalleAttach the correoDetalleAttach to set
	 */
	public void setCorreoDetalleAttach(String correoDetalleAttach) {
		this.correoDetalleAttach = correoDetalleAttach;
	}

}
