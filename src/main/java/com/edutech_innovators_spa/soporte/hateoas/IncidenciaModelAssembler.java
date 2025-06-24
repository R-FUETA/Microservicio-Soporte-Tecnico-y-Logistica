package com.edutech_innovators_spa.soporte.hateoas;

import com.edutech_innovators_spa.soporte.controller.SoporteController;
import com.edutech_innovators_spa.soporte.model.Incidencia;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class IncidenciaModelAssembler implements RepresentationModelAssembler<Incidencia, EntityModel<Incidencia>> {

    @Override
    public EntityModel<Incidencia> toModel(Incidencia incidencia) {
        return EntityModel.of(
            incidencia,
            linkTo(methodOn(SoporteController.class).listarIncidencias()).withRel("incidencias"),
            linkTo(SoporteController.class).slash("incidencias").slash(incidencia.getId()).slash("estado").withRel("cambiarEstado")
        );
    }
}