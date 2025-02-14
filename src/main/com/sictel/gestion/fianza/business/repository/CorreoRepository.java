/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sictel.gestion.fianza.business.entitie.Correo;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface CorreoRepository extends JpaRepository<Correo, String> {

}
