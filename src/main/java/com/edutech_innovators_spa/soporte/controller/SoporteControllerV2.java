package com.edutech_innovators_spa.soporte.controller;

import com.edutech_innovators_spa.soporte.model.Incidencia;
import com.edutech_innovators_spa.soporte.model.Proveedor;
import com.edutech_innovators_spa.soporte.service.SoporteService;
import com.edutech_innovators_spa.soporte.hateoas.IncidenciaModelAssembler;
import com.edutech_innovators_spa.soporte.hateoas.ProveedorModelAssembler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/soporte")
@Tag(name = "Soporte Tecnico", description = "PENDIENTE")
public class SoporteControllerV2 {

    @Autowired
    private SoporteService soporteService;

    @Autowired
    private IncidenciaModelAssembler incidenciaAssembler;

    @Autowired
    private ProveedorModelAssembler proveedorAssembler;

    @Operation(summary = "Reporte", description = "Permite reportar una nueva incidencia")
    @PostMapping("/incidencias")
    public EntityModel<Incidencia> reportar(@RequestBody Incidencia incidencia) {
        Incidencia nueva = soporteService.reportarIncidencia(incidencia);
        return incidenciaAssembler.toModel(nueva);
    }

    @Operation(summary = "Actualizar Estado", description = "Permite Actualizar el Estado de la incidencia")
    @PutMapping("/incidencias/{id}/estado")
    public EntityModel<Incidencia> cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        Incidencia actualizada = soporteService.actualizarEstado(id, estado);
        return incidenciaAssembler.toModel(actualizada);
    }

    @Operation(summary = "Lista de Incidencias", description = "Permite Visualizar Todas las incidencias Creadas")
    @GetMapping("/incidencias")
    public CollectionModel<EntityModel<Incidencia>> listarIncidencias() {
        List<EntityModel<Incidencia>> incidencias = soporteService.listarIncidencias()
            .stream()
            .map(incidenciaAssembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(incidencias,
            linkTo(methodOn(SoporteController.class).listarIncidencias()).withSelfRel());
    }

    @Operation(summary = "Registrar Proveerdor", description = "Permite Registrar un nuevo Proveedor")
    @PostMapping("/proveedores")
    public EntityModel<Proveedor> agregarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevo = soporteService.agregarProveedor(proveedor);
        return proveedorAssembler.toModel(nuevo);
    }

    @Operation(summary = "Lista Proveedores", description = "Permite Visualizar los Proveedores registrados")
    @GetMapping("/proveedores")
    public CollectionModel<EntityModel<Proveedor>> listarProveedores() {
        List<EntityModel<Proveedor>> proveedores = soporteService.listarProveedores()
            .stream()
            .map(proveedorAssembler::toModel)
            .collect(Collectors.toList());
        return CollectionModel.of(proveedores,
            linkTo(methodOn(SoporteController.class).listarProveedores()).withSelfRel());
    }
}