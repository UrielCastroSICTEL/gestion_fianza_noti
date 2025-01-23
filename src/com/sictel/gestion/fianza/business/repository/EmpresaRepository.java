/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sictel.gestion.fianza.business.entitie.Empresa;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Short> {

	@Query("SELECT e FROM Empresa e WHERE e.empresaTipoId = ?1 AND e.empresaAct = ?2")
	List<Empresa> participante(String string, Boolean activo);

}
