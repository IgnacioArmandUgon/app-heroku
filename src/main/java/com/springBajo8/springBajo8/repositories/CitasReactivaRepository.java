package com.springBajo8.springBajo8.repositories;

import java.time.LocalDate;

import com.springBajo8.springBajo8.models.citasDTOReactiva;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CitasReactivaRepository extends ReactiveMongoRepository<citasDTOReactiva, String> {
  Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);
  Flux<citasDTOReactiva> findByFechaReservaCita(LocalDate fecha);
}
