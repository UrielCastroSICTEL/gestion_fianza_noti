/**
 * 
 */
package com.sictel.gestion.fianza.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sictel.gestion.fianza.business.entitie.Notificacion;

/**
 * @author Uriel Castro ucastro@sictel.com
 *
 */
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

}
