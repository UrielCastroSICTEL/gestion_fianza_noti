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
@Table(name = "empresa")
public class Empresa {

	@Id
	@Column(name = "`empresaId`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short empresaId;

	@Column(name = "`empresaNomb`")
	private String empresaNomb;

	@Column(name = "`empresaSigla`")
	private String empresaSigla;

	@Column(name = "`empresaTipoId`")
	private String empresaTipoId;

	@Column(name = "`empresaAct`")
	private Boolean empresaAct;

	/**
	 * @return the empresaId
	 */
	public Short getEmpresaId() {
		return empresaId;
	}

	/**
	 * @param empresaId the empresaId to set
	 */
	public void setEmpresaId(Short empresaId) {
		this.empresaId = empresaId;
	}

	/**
	 * @return the empresaNomb
	 */
	public String getEmpresaNomb() {
		return empresaNomb;
	}

	/**
	 * @param empresaNomb the empresaNomb to set
	 */
	public void setEmpresaNomb(String empresaNomb) {
		this.empresaNomb = empresaNomb;
	}

	/**
	 * @return the empresaSigla
	 */
	public String getEmpresaSigla() {
		return empresaSigla;
	}

	/**
	 * @param empresaSigla the empresaSigla to set
	 */
	public void setEmpresaSigla(String empresaSigla) {
		this.empresaSigla = empresaSigla;
	}

	/**
	 * @return the empresaTipoId
	 */
	public String getEmpresaTipoId() {
		return empresaTipoId;
	}

	/**
	 * @param empresaTipoId the empresaTipoId to set
	 */
	public void setEmpresaTipoId(String empresaTipoId) {
		this.empresaTipoId = empresaTipoId;
	}

	/**
	 * @return the empresaAct
	 */
	public Boolean getEmpresaAct() {
		return empresaAct;
	}

	/**
	 * @param empresaAct the empresaAct to set
	 */
	public void setEmpresaAct(Boolean empresaAct) {
		this.empresaAct = empresaAct;
	}

}
