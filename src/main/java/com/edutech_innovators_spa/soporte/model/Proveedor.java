
package com.edutech_innovators_spa.soporte.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa a un proveedor tecnológico o logístico vinculado al sistema.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del proveedor.
     */
    private String nombre;

    /**
     * Información de contacto del proveedor (email, teléfono, etc.).
     */
    private String contacto;

    /**
     * Tipo de servicio que ofrece el proveedor (hardware, software, logística, etc.).
     */
    private String servicio;
}
