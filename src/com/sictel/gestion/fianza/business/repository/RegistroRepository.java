/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sictel.gestion.fianza.business.entitie.Registro;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface RegistroRepository extends JpaRepository<Registro, Long> {

	@Query("SELECT COUNT(r) FROM Registro r WHERE r.registroConteId IS NULL AND r.registroElemeId IS NULL AND r.registroCreadoInt/10000 = ?1")
	Integer preRegistroNoAño(Integer año);

	@Query("SELECT r FROM Registro r WHERE r.registroConteId IS NULL AND r.registroElemeId IS NULL ORDER BY r.registroCreadoInt DESC")
	List<Registro> activos();

}
