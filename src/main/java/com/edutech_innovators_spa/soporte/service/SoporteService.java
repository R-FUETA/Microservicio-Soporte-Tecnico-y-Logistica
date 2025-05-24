
package com.edutech_innovators_spa.soporte.service;

import com.edutech_innovators_spa.soporte.model.Incidencia;
import com.edutech_innovators_spa.soporte.model.Proveedor;
import com.edutech_innovators_spa.soporte.repository.IncidenciaRepository;
import com.edutech_innovators_spa.soporte.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que contiene la lógica de negocio del microservicio de soporte técnico y logística.
 * Administra incidencias reportadas, estados y la gestión de proveedores.
 */
@Service
public class SoporteService {

    @Autowired
    private IncidenciaRepository incidenciaRepo;

    @Autowired
    private ProveedorRepository proveedorRepo;

    /**
     * Registra una nueva incidencia en la base de datos.
     */
    public Incidencia reportarIncidencia(Incidencia incidencia) {
        return incidenciaRepo.save(incidencia);
    }

    /**
     * Devuelve la lista de todas las incidencias registradas.
     */
    public List<Incidencia> listarIncidencias() {
        return incidenciaRepo.findAll();
    }

    /**
     * Actualiza el estado de una incidencia existente.
     */
    public Incidencia actualizarEstado(Long id, String estado) {
        Incidencia i = incidenciaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));
        i.setEstado(estado);
        return incidenciaRepo.save(i);
    }

    /**
     * Registra un nuevo proveedor.
     */
    public Proveedor agregarProveedor(Proveedor proveedor) {
        return proveedorRepo.save(proveedor);
    }

    /**
     * Devuelve la lista de todos los proveedores registrados.
     */
    public List<Proveedor> listarProveedores() {
        return proveedorRepo.findAll();
    }
}
