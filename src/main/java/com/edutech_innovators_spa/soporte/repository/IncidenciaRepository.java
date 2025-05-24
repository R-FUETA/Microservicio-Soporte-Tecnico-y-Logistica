
package com.edutech_innovators_spa.soporte.repository;

import com.edutech_innovators_spa.soporte.model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para manejar operaciones CRUD sobre la entidad Incidencia.
 */
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
}
