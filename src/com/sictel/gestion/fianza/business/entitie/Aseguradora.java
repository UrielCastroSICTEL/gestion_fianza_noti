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
@Table(name = "aseguradora")
public class Aseguradora {

	@Id
	@Column(name = "`aseguradoraId`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short aseguradoraId;

	@Column(name = "`aseguradoraNomb`")
	private String aseguradoraNomb;

	@Column(name = "`aseguradoraAct`")
	private Boolean aseguradoraAct;

	/**
	 * @return the aseguradoraId
	 */
	public Short getAseguradoraId() {
		return aseguradoraId;
	}

	/**
	 * @param aseguradoraId the aseguradoraId to set
	 */
	public void setAseguradoraId(Short aseguradoraId) {
		this.aseguradoraId = aseguradoraId;
	}

	/**
	 * @return the aseguradoraNomb
	 */
	public String getAseguradoraNomb() {
		return aseguradoraNomb;
	}

	/**
	 * @param aseguradoraNomb the aseguradoraNomb to set
	 */
	public void setAseguradoraNomb(String aseguradoraNomb) {
		this.aseguradoraNomb = aseguradoraNomb;
	}

	/**
	 * @return the aseguradoraAct
	 */
	public Boolean getAseguradoraAct() {
		return aseguradoraAct;
	}

	/**
	 * @param aseguradoraAct the aseguradoraAct to set
	 */
	public void setAseguradoraAct(Boolean aseguradoraAct) {
		this.aseguradoraAct = aseguradoraAct;
	}

}
