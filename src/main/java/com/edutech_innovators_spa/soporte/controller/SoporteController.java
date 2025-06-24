
package com.edutech_innovators_spa.soporte.controller;

import com.edutech_innovators_spa.soporte.model.Incidencia;
import com.edutech_innovators_spa.soporte.model.Proveedor;
import com.edutech_innovators_spa.soporte.service.SoporteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone los endpoints del microservicio de Soporte Técnico y Logística.
 * Permite gestionar incidencias y proveedores.
 */
@RestController
@RequestMapping("/api/v1/soporte")
@Tag(name = "Soporte Tecnico", description = ("PENDIENTE"))
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    /**
     * Endpoint para reportar una nueva incidencia.
     */
    @Operation(summary = "Reporte", description = "Permite reportar una nueva incidencia")
    @PostMapping("/incidencias")
    public Incidencia reportar(@RequestBody Incidencia incidencia) {
        return soporteService.reportarIncidencia(incidencia);
    }

    /**
     * Endpoint para actualizar el estado de una incidencia.
     */
    @Operation(summary = "Actualizar Estado", description = "Permite Actualizar el Estado de la incidencia")
    @PutMapping("/incidencias/{id}/estado")
    public Incidencia cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        return soporteService.actualizarEstado(id, estado);
    }

    /**
     * Endpoint para obtener todas las incidencias.
     */
    @Operation(summary = "Lista de Incidencias", description = "Permite Visualizar Todas las incidencias Creadas")
    @GetMapping("/incidencias")
    public List<Incidencia> listarIncidencias() {
        return soporteService.listarIncidencias();
    }

    /**
     * Endpoint para registrar un nuevo proveedor.
     */
    @Operation(summary = "Registrar Proveerdor", description = "Permite Registrar un nuevo Proveedor")
    @PostMapping("/proveedores")
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor) {
        return soporteService.agregarProveedor(proveedor);
    }

    /**
     * Endpoint para obtener todos los proveedores.
     */
    @Operation(summary = "Lista Proveedores", description = "Permite Visualizar los Proveedores registrados")
    @GetMapping("/proveedores")
    public List<Proveedor> listarProveedores() {
        return soporteService.listarProveedores();
    }
}
