/**
 * 
 */
package com.sictel.gestion.fianza.business.entitie;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
@Entity
@Table(name = "notificacion")
public class Notificacion {

	@Id
	@Column(name = "`notificacionId`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificacionId;

	@Column(name = "`registroId`")
	private Long registroId;

	@Column(name = "`notificacionFech`")
	private Date notificacionFech;

	@Column(name = "`notificacionFechInt`")
	private Integer notificacionFechInt;

	@Column(name = "`notificacionEnvi`")
	private Boolean notificacionEnvi;

	@Column(name = "`notificacionTipo`")
	private String notificacionTipo;

	/**
	 * @return the notificacionId
	 */
	public Long getNotificacionId() {
		return notificacionId;
	}

	/**
	 * @param notificacionId the notificacionId to set
	 */
	public void setNotificacionId(Long notificacionId) {
		this.notificacionId = notificacionId;
	}

	/**
	 * @return the registroId
	 */
	public Long getRegistroId() {
		return registroId;
	}

	/**
	 * @param registroId the registroId to set
	 */
	public void setRegistroId(Long registroId) {
		this.registroId = registroId;
	}

	/**
	 * @return the notificacionFech
	 */
	public Date getNotificacionFech() {
		return notificacionFech;
	}

	/**
	 * @param notificacionFech the notificacionFech to set
	 */
	public void setNotificacionFech(Date notificacionFech) {
		this.notificacionFech = notificacionFech;
	}

	/**
	 * @return the notificacionFechInt
	 */
	public Integer getNotificacionFechInt() {
		return notificacionFechInt;
	}

	/**
	 * @param notificacionFechInt the notificacionFechInt to set
	 */
	public void setNotificacionFechInt(Integer notificacionFechInt) {
		this.notificacionFechInt = notificacionFechInt;
	}

	/**
	 * @return the notificacionEnvi
	 */
	public Boolean getNotificacionEnvi() {
		return notificacionEnvi;
	}

	/**
	 * @param notificacionEnvi the notificacionEnvi to set
	 */
	public void setNotificacionEnvi(Boolean notificacionEnvi) {
		this.notificacionEnvi = notificacionEnvi;
	}

	/**
	 * @return the notificacionTipo
	 */
	public String getNotificacionTipo() {
		return notificacionTipo;
	}

	/**
	 * @param notificacionTipo the notificacionTipo to set
	 */
	public void setNotificacionTipo(String notificacionTipo) {
		this.notificacionTipo = notificacionTipo;
	}

}
