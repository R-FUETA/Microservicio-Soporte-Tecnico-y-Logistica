package com.edutech_innovators_spa.soporte.hateoas;

import com.edutech_innovators_spa.soporte.controller.SoporteController;
import com.edutech_innovators_spa.soporte.model.Proveedor;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProveedorModelAssembler implements RepresentationModelAssembler<Proveedor, EntityModel<Proveedor>> {

    @Override
    public EntityModel<Proveedor> toModel(Proveedor proveedor) {
        return EntityModel.of(
            proveedor,
            linkTo(methodOn(SoporteController.class).listarProveedores()).withRel("proveedores")
        );
    }
}