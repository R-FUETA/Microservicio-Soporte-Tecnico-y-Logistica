
package com.edutech_innovators_spa.soporte.repository;

import com.edutech_innovators_spa.soporte.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio JPA para manejar operaciones CRUD sobre la entidad Proveedor.
 */
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
