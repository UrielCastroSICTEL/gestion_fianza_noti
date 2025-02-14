/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sictel.gestion.fianza.business.entitie.Comercial;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface ComercialRepository extends JpaRepository<Comercial, String> {

	@Query("SELECT c FROM Comercial c WHERE c.comercialAct = ?1")
	List<Comercial> comerciales(Boolean activo);

}
