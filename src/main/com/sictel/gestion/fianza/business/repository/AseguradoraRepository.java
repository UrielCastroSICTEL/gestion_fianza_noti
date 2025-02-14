/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sictel.gestion.fianza.business.entitie.Aseguradora;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface AseguradoraRepository extends JpaRepository<Aseguradora, Short> {

	@Query("SELECT a FROM Aseguradora a WHERE a.aseguradoraAct = ?1")
	List<Aseguradora> aseguradoras(Boolean activo);

}
