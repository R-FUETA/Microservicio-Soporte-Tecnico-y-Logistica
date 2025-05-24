
package com.edutech_innovators_spa.soporte.controller;

import com.edutech_innovators_spa.soporte.model.Incidencia;
import com.edutech_innovators_spa.soporte.model.Proveedor;
import com.edutech_innovators_spa.soporte.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone los endpoints del microservicio de Soporte Técnico y Logística.
 * Permite gestionar incidencias y proveedores.
 */
@RestController
@RequestMapping("/api/soporte")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    /**
     * Endpoint para reportar una nueva incidencia.
     */
    @PostMapping("/incidencias")
    public Incidencia reportar(@RequestBody Incidencia incidencia) {
        return soporteService.reportarIncidencia(incidencia);
    }

    /**
     * Endpoint para actualizar el estado de una incidencia.
     */
    @PutMapping("/incidencias/{id}/estado")
    public Incidencia cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        return soporteService.actualizarEstado(id, estado);
    }

    /**
     * Endpoint para obtener todas las incidencias.
     */
    @GetMapping("/incidencias")
    public List<Incidencia> listarIncidencias() {
        return soporteService.listarIncidencias();
    }

    /**
     * Endpoint para registrar un nuevo proveedor.
     */
    @PostMapping("/proveedores")
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor) {
        return soporteService.agregarProveedor(proveedor);
    }

    /**
     * Endpoint para obtener todos los proveedores.
     */
    @GetMapping("/proveedores")
    public List<Proveedor> listarProveedores() {
        return soporteService.listarProveedores();
    }
}
