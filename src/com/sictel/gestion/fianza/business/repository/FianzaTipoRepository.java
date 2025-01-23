/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sictel.gestion.fianza.business.entitie.FianzaTipo;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface FianzaTipoRepository extends JpaRepository<FianzaTipo, Short> {

	@Query("SELECT f FROM FianzaTipo f WHERE f.fianzaTipoAct = ?1")
	List<FianzaTipo> fianzaTipos(Boolean activo);

	@Query("SELECT f FROM FianzaTipo f WHERE f.fianzaTipo = ?1 AND f.fianzaTipoAct = ?2")
	List<FianzaTipo> fianzaTipos(String fianzaTipo, Boolean activo);

}
