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
@Table(name = "comercial")
public class Comercial {

	@Id
	@Column(name = "`comercialId`")
	private String comercialId;

	@Column(name = "`comercialNomb`")
	private String comercialNomb;

	@Column(name = "`comercialEmail`")
	private String comercialEmail;

	@Column(name = "`comercialAct`")
	private Boolean comercialAct;

	/**
	 * @return the comercialId
	 */
	public String getComercialId() {
		return comercialId;
	}

	/**
	 * @param comercialId the comercialId to set
	 */
	public void setComercialId(String comercialId) {
		this.comercialId = comercialId;
	}

	/**
	 * @return the comercialNomb
	 */
	public String getComercialNomb() {
		return comercialNomb;
	}

	/**
	 * @param comercialNomb the comercialNomb to set
	 */
	public void setComercialNomb(String comercialNomb) {
		this.comercialNomb = comercialNomb;
	}

	/**
	 * @return the comercialEmail
	 */
	public String getComercialEmail() {
		return comercialEmail;
	}

	/**
	 * @param comercialEmail the comercialEmail to set
	 */
	public void setComercialEmail(String comercialEmail) {
		this.comercialEmail = comercialEmail;
	}

	/**
	 * @return the comercialAct
	 */
	public Boolean getComercialAct() {
		return comercialAct;
	}

	/**
	 * @param comercialAct the comercialAct to set
	 */
	public void setComercialAct(Boolean comercialAct) {
		this.comercialAct = comercialAct;
	}

}
