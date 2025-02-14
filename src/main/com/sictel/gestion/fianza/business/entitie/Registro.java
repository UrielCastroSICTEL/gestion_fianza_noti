/**
 * 
 */
package com.sictel.gestion.fianza.business.entitie;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
@Entity
@Table(name = "registro")
public class Registro {

	@Id
	@Column(name = "`registroId`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registroId;

	@Column(name = "`registroConteId`")
	private Integer registroConteId;

	@Column(name = "`registroElemeId`")
	private Long registroElemeId;

	@Column(name = "`registroTipo`")
	private String registroTipo;

	@Column(name = "`registroTipoId`")
	private Short registroTipoId;

	@Column(name = "`registroEmpreLocId`")
	private Short registroEmpreLocId;

	@Column(name = "`registroEmpreExtId`")
	private Short registroEmpreExtId;

	@Column(name = "`registroAseguId`")
	private Short registroAseguId;

	@Column(name = "`registroCreado`")
	private Date registroCreado;

	@Column(name = "`registroCreadoInt`")
	private Integer registroCreadoInt;

	@Column(name = "`registroCome`")
	private String registroCome;

	@Column(name = "`registroCrea`")
	private String registroCrea;

	@Column(name = "`registroResp`")
	private String registroResp;

	@Column(name = "`registroVal`")
	private Boolean registroVal;

	@Column(name = "`registroAct`")
	private Boolean registroAct;

	@JoinColumn(name = "`registroTipoId`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private FianzaTipo fianzaTipo;

	@JoinColumn(name = "`registroEmpreLocId`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Empresa empresaLocal;

	@JoinColumn(name = "`registroEmpreExtId`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Empresa empresaExter;

	@JoinColumn(name = "`registroAseguId`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Aseguradora aseguradora;

	@JoinColumn(name = "`registroCome`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Comercial comercial;

	@JoinColumn(name = "`registroCrea`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Empleado empleado;

	@JoinColumn(name = "`registroResp`", insertable = false, updatable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private Empleado responsable;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "`registroId`", referencedColumnName = "`registroId`", insertable = false, updatable = false)
	List<Notificacion> notificaciones;

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
	 * @return the registroConteId
	 */
	public Integer getRegistroConteId() {
		return registroConteId;
	}

	/**
	 * @param registroConteId the registroConteId to set
	 */
	public void setRegistroConteId(Integer registroConteId) {
		this.registroConteId = registroConteId;
	}

	/**
	 * @return the registroElemeId
	 */
	public Long getRegistroElemeId() {
		return registroElemeId;
	}

	/**
	 * @param registroElemeId the registroElemeId to set
	 */
	public void setRegistroElemeId(Long registroElemeId) {
		this.registroElemeId = registroElemeId;
	}

	/**
	 * @return the registroTipo
	 */
	public String getRegistroTipo() {
		return registroTipo;
	}

	/**
	 * @param registroTipo the registroTipo to set
	 */
	public void setRegistroTipo(String registroTipo) {
		this.registroTipo = registroTipo;
	}

	/**
	 * @return the registroTipoId
	 */
	public Short getRegistroTipoId() {
		return registroTipoId;
	}

	/**
	 * @param registroTipoId the registroTipoId to set
	 */
	public void setRegistroTipoId(Short registroTipoId) {
		this.registroTipoId = registroTipoId;
	}

	/**
	 * @return the registroEmpreLocId
	 */
	public Short getRegistroEmpreLocId() {
		return registroEmpreLocId;
	}

	/**
	 * @param registroEmpreLocId the registroEmpreLocId to set
	 */
	public void setRegistroEmpreLocId(Short registroEmpreLocId) {
		this.registroEmpreLocId = registroEmpreLocId;
	}

	/**
	 * @return the registroEmpreExtId
	 */
	public Short getRegistroEmpreExtId() {
		return registroEmpreExtId;
	}

	/**
	 * @param registroEmpreExtId the registroEmpreExtId to set
	 */
	public void setRegistroEmpreExtId(Short registroEmpreExtId) {
		this.registroEmpreExtId = registroEmpreExtId;
	}

	/**
	 * @return the registroAseguId
	 */
	public Short getRegistroAseguId() {
		return registroAseguId;
	}

	/**
	 * @param registroAseguId the registroAseguId to set
	 */
	public void setRegistroAseguId(Short registroAseguId) {
		this.registroAseguId = registroAseguId;
	}

	/**
	 * @return the registroCreado
	 */
	public Date getRegistroCreado() {
		return registroCreado;
	}

	/**
	 * @param registroCreado the registroCreado to set
	 */
	public void setRegistroCreado(Date registroCreado) {
		this.registroCreado = registroCreado;
	}

	/**
	 * @return the registroCreadoInt
	 */
	public Integer getRegistroCreadoInt() {
		return registroCreadoInt;
	}

	/**
	 * @param registroCreadoInt the registroCreadoInt to set
	 */
	public void setRegistroCreadoInt(Integer registroCreadoInt) {
		this.registroCreadoInt = registroCreadoInt;
	}

	/**
	 * @return the registroCome
	 */
	public String getRegistroCome() {
		return registroCome;
	}

	/**
	 * @param registroCome the registroCome to set
	 */
	public void setRegistroCome(String registroCome) {
		this.registroCome = registroCome;
	}

	/**
	 * @return the registroCrea
	 */
	public String getRegistroCrea() {
		return registroCrea;
	}

	/**
	 * @param registroCrea the registroCrea to set
	 */
	public void setRegistroCrea(String registroCrea) {
		this.registroCrea = registroCrea;
	}

	/**
	 * @return the registroResp
	 */
	public String getRegistroResp() {
		return registroResp;
	}

	/**
	 * @param registroResp the registroResp to set
	 */
	public void setRegistroResp(String registroResp) {
		this.registroResp = registroResp;
	}

	/**
	 * @return the registroVal
	 */
	public Boolean getRegistroVal() {
		return registroVal;
	}

	/**
	 * @param registroVal the registroVal to set
	 */
	public void setRegistroVal(Boolean registroVal) {
		this.registroVal = registroVal;
	}

	/**
	 * @return the registroAct
	 */
	public Boolean getRegistroAct() {
		return registroAct;
	}

	/**
	 * @param registroAct the registroAct to set
	 */
	public void setRegistroAct(Boolean registroAct) {
		this.registroAct = registroAct;
	}

	/**
	 * @return the fianzaTipo
	 */
	public FianzaTipo getFianzaTipo() {
		return fianzaTipo;
	}

	/**
	 * @param fianzaTipo the fianzaTipo to set
	 */
	public void setFianzaTipo(FianzaTipo fianzaTipo) {
		this.fianzaTipo = fianzaTipo;
	}

	/**
	 * @return the empresaLocal
	 */
	public Empresa getEmpresaLocal() {
		return empresaLocal;
	}

	/**
	 * @param empresaLocal the empresaLocal to set
	 */
	public void setEmpresaLocal(Empresa empresaLocal) {
		this.empresaLocal = empresaLocal;
	}

	/**
	 * @return the empresaExter
	 */
	public Empresa getEmpresaExter() {
		return empresaExter;
	}

	/**
	 * @param empresaExter the empresaExter to set
	 */
	public void setEmpresaExter(Empresa empresaExter) {
		this.empresaExter = empresaExter;
	}

	/**
	 * @return the aseguradora
	 */
	public Aseguradora getAseguradora() {
		return aseguradora;
	}

	/**
	 * @param aseguradora the aseguradora to set
	 */
	public void setAseguradora(Aseguradora aseguradora) {
		this.aseguradora = aseguradora;
	}

	/**
	 * @return the comercial
	 */
	public Comercial getComercial() {
		return comercial;
	}

	/**
	 * @param comercial the comercial to set
	 */
	public void setComercial(Comercial comercial) {
		this.comercial = comercial;
	}

	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the responsable
	 */
	public Empleado getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}

	/**
	 * @return the notificaciones
	 */
	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	/**
	 * @param notificaciones the notificaciones to set
	 */
	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

}
