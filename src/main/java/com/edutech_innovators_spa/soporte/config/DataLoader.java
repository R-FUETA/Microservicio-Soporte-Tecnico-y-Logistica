package com.edutech_innovators_spa.soporte.config;

import com.edutech_innovators_spa.soporte.model.Incidencia;
import com.edutech_innovators_spa.soporte.model.Proveedor;
import com.edutech_innovators_spa.soporte.repository.IncidenciaRepository;
import com.edutech_innovators_spa.soporte.repository.ProveedorRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    private final Random random = new Random();
    private final String[] estados = {"PENDIENTE", "EN_PROGRESO", "RESUELTA"};
    private final String[] tiposServicio = {"Hardware", "Software", "Logística", "Redes", "Mantenimiento"};

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 1. Crear 15 proveedores
        for (int i = 0; i < 15; i++) {
            Proveedor proveedor = Proveedor.builder()
                    .nombre(faker.company().name())
                    .contacto(faker.internet().emailAddress() + " / " + faker.phoneNumber().cellPhone())
                    .servicio(tiposServicio[random.nextInt(tiposServicio.length)])
                    .build();

            proveedorRepository.save(proveedor);
        }

        // 2. Crear 30 incidencias
        for (int i = 0; i < 30; i++) {
            Incidencia incidencia = Incidencia.builder()
                    .descripcion(faker.lorem().sentence(12))
                    .estado(estados[random.nextInt(estados.length)])
                    .fechaReporte(LocalDate.now().minusDays(random.nextInt(60)).format(formatter)) // últimos 2 meses
                    .build();

            incidenciaRepository.save(incidencia);
        }

        System.out.println("Datos de prueba generados para proveedores e incidencias.");
    }
}
