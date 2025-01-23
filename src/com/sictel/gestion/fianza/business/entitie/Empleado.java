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
@Table(name = "empleado_fia")
public class Empleado {

	@Id
	@Column(name = "`empleadoId`")
	private String empleadoId;

	@Column(name = "`rolId`")
	private String rolId;

	@Column(name = "`empleadoNomCompl`")
	private String empleadoNomCompl;

	@Column(name = "`empleadoEmail`")
	private String empleadoEmail;

	@Column(name = "`empleadoAct`")
	private Boolean empleadoAct;

	/**
	 * @return the empleadoId
	 */
	public String getEmpleadoId() {
		return empleadoId;
	}

	/**
	 * @param empleadoId the empleadoId to set
	 */
	public void setEmpleadoId(String empleadoId) {
		this.empleadoId = empleadoId;
	}

	/**
	 * @return the rolId
	 */
	public String getRolId() {
		return rolId;
	}

	/**
	 * @param rolId the rolId to set
	 */
	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	/**
	 * @return the empleadoNomCompl
	 */
	public String getEmpleadoNomCompl() {
		return empleadoNomCompl;
	}

	/**
	 * @param empleadoNomCompl the empleadoNomCompl to set
	 */
	public void setEmpleadoNomCompl(String empleadoNomCompl) {
		this.empleadoNomCompl = empleadoNomCompl;
	}

	/**
	 * @return the empleadoEmail
	 */
	public String getEmpleadoEmail() {
		return empleadoEmail;
	}

	/**
	 * @param empleadoEmail the empleadoEmail to set
	 */
	public void setEmpleadoEmail(String empleadoEmail) {
		this.empleadoEmail = empleadoEmail;
	}

	/**
	 * @return the empleadoAct
	 */
	public Boolean getEmpleadoAct() {
		return empleadoAct;
	}

	/**
	 * @param empleadoAct the empleadoAct to set
	 */
	public void setEmpleadoAct(Boolean empleadoAct) {
		this.empleadoAct = empleadoAct;
	}

}
