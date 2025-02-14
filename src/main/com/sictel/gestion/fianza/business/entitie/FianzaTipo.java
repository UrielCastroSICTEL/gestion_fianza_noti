/**
 * 
 */
package com.sictel.gestion.fianza.business.entitie;

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
@Table(name = "fianza_tipo")
public class FianzaTipo {

	@Id
	@Column(name = "`fianzaTipoId`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short fianzaTipoId;

	@Column(name = "`fianzaTipoSigla`")
	private String fianzaTipoSigla;

	@Column(name = "`fianzaTipoNomb`")
	private String fianzaTipoNomb;

	@Column(name = "`fianzaTipo`")
	private String fianzaTipo;

	@Column(name = "`fianzaTipoAct`")
	private Boolean fianzaTipoAct;

	/**
	 * @return the fianzaTipoId
	 */
	public Short getFianzaTipoId() {
		return fianzaTipoId;
	}

	/**
	 * @param fianzaTipoId the fianzaTipoId to set
	 */
	public void setFianzaTipoId(Short fianzaTipoId) {
		this.fianzaTipoId = fianzaTipoId;
	}

	/**
	 * @return the fianzaTipoSigla
	 */
	public String getFianzaTipoSigla() {
		return fianzaTipoSigla;
	}

	/**
	 * @param fianzaTipoSigla the fianzaTipoSigla to set
	 */
	public void setFianzaTipoSigla(String fianzaTipoSigla) {
		this.fianzaTipoSigla = fianzaTipoSigla;
	}

	/**
	 * @return the fianzaTipoNomb
	 */
	public String getFianzaTipoNomb() {
		return fianzaTipoNomb;
	}

	/**
	 * @param fianzaTipoNomb the fianzaTipoNomb to set
	 */
	public void setFianzaTipoNomb(String fianzaTipoNomb) {
		this.fianzaTipoNomb = fianzaTipoNomb;
	}

	/**
	 * @return the fianzaTipo
	 */
	public String getFianzaTipo() {
		return fianzaTipo;
	}

	/**
	 * @param fianzaTipo the fianzaTipo to set
	 */
	public void setFianzaTipo(String fianzaTipo) {
		this.fianzaTipo = fianzaTipo;
	}

	/**
	 * @return the fianzaTipoAct
	 */
	public Boolean getFianzaTipoAct() {
		return fianzaTipoAct;
	}

	/**
	 * @param fianzaTipoAct the fianzaTipoAct to set
	 */
	public void setFianzaTipoAct(Boolean fianzaTipoAct) {
		this.fianzaTipoAct = fianzaTipoAct;
	}

}
