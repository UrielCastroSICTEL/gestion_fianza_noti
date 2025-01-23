/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sictel.gestion.fianza.business.entitie.Empleado;


/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

	@Query("SELECT e FROM Empleado e WHERE e.empleadoId= ?1 AND e.empleadoAct= true")
	List<Empleado> buscarEmpleadoId(String empleadoId);

//	@Query("SELECT MAX(e.empleadoId) FROM Empleado e WHERE e.adId= ?1")
//	String obtenerId(String adId);
//
//	@Query("SELECT e FROM Empleado e WHERE e.adId= ?1")
//	List<Empleado> buscarAdId(String adId);
//
//	@Query("SELECT e FROM Empleado e WHERE e.adId= ?1 AND e.empleadoExterno= ?2 AND e.empleadoAct= true")
//	List<Empleado> buscarAdId(String adId, Boolean externo);
//
//	@Query("SELECT e FROM Empleado e WHERE e.empleadoExterno= ?1 AND rolId != 'ADMIN'")
//	List<Empleado> empleados(Boolean externo);
//
//	@Query("SELECT DISTINCT(e.empleadoArea) FROM Empleado e")
//	List<String> areas();
//
//	@Query("SELECT e FROM Empleado e WHERE e.empleadoAct= true ORDER BY e.empleadoNomComplMayu DESC")
//	List<Empleado> todosActivos();
//
//	@Query("SELECT DISTINCT(e.empleadoEstrucNivel) FROM Empleado e WHERE e.empleadoExterno= true")
//	List<String> empresas();
//
//	@Query("SELECT e FROM Empleado e WHERE e.empleadoAct= true AND rolId = ?1")
//	List<Empleado> empleados(String rolId);

}
