
package com.edutech_innovators_spa.soporte.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa una incidencia técnica o de soporte reportada en el sistema.
 * Puede ser un problema técnico, solicitud de mantenimiento u otra situación relacionada al área de soporte.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Descripción detallada de la incidencia reportada.
     */
    private String descripcion;

    /**
     * Estado actual de la incidencia: PENDIENTE, EN_PROGRESO, RESUELTA.
     */
    private String estado;

    /**
     * Fecha en que fue reportada la incidencia (formato: yyyy-MM-dd).
     */
    private String fechaReporte;
}
