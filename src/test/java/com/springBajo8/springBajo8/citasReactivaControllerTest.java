package com.springBajo8.springBajo8;

import java.util.ArrayList;
import java.util.List;

import com.springBajo8.springBajo8.models.PadecimientoTratamiento;
import com.springBajo8.springBajo8.models.citasDTOReactiva;
import com.springBajo8.springBajo8.services.CitasReactivaService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class citasReactivaControllerTest {
  @Autowired
  private CitasReactivaService service;
 
  @Test
  @DisplayName("Get cita by Id")
  void getCitaById() {
    citasDTOReactiva cita = new citasDTOReactiva("65a5593f-a", "3", "Kike", "Mata", "Juan", "Sosa", "2022-03-30", "17:17", "Cancelado", null);
    Mono<citasDTOReactiva> find = service.findById("65a5593f-a");
    StepVerifier.create(find).expectNext(cita);
  }

  @Test
  @DisplayName("Get cita by Id Paciente")
  void getCitaByIdPaciente() {
    citasDTOReactiva cita = new citasDTOReactiva("65a5593f-a", "3", "Kike", "Mata", "Juan", "Sosa", "2022-03-30", "17:17", "Cancelado", null);
    Flux<citasDTOReactiva> find = service.findByIdPaciente("3");
    StepVerifier.create(find).expectNext(cita);
  }

  @Test
  @DisplayName("Add new cita")
  void postNewCita() {
    citasDTOReactiva cita = new citasDTOReactiva("1", "Pedro", "Alvarez", "Bob", "Marley", "2022-02-22", "18:34", "Reservada", null);
    Mono<citasDTOReactiva> citas = service.save(cita);
    StepVerifier.create(citas).expectNext(cita);
  }

  @Test
  @DisplayName("Edit a cita")
  void getCitaByIdAndCancel() {
    citasDTOReactiva cita = new citasDTOReactiva("65a5593f-a","1", "Pedro", "Alvarez", "Bob", "Marley", "2022-02-22", "18:34", "Reservada", null);
    Mono<citasDTOReactiva> cancel = service.cancelarCita("65a5593f-a");
    StepVerifier.create(cancel).expectNext(cita);
  }

  @Test
  @DisplayName("Find citas by DateAndHour")
  void consultarDateAndHour() {
    citasDTOReactiva cita = new citasDTOReactiva("1", "Pedro", "Alvarez", "Bob", "Marley", "2022-02-22", "18:34", "Reservada", null);
    Flux<citasDTOReactiva> uno = service.consultarFechaYHora(cita.getFechaReservaCita(),cita.getHoraReservaCita());
    StepVerifier.create(uno).expectNext(cita);
  }

  @Test
  @DisplayName("Find medico by citaId")
  void consultarMedico() {
    citasDTOReactiva cita = new citasDTOReactiva("1", "Pedro", "Alvarez", "Bob", "Marley", "2022-02-22", "18:34", "Reservada", null);
      Mono<citasDTOReactiva> uno = service.consultarMedico("1");
      StepVerifier.create(uno).expectNext(cita);
  }

  @Test
  @DisplayName("Find tratamientos by citaId")
  void consultarPadecimientoTratamiento() {
    PadecimientoTratamiento padecimiento = new PadecimientoTratamiento("mucha facha", "dormir");
    List<PadecimientoTratamiento> lista = new ArrayList<PadecimientoTratamiento>();
    lista.add(padecimiento);
    citasDTOReactiva cita = new citasDTOReactiva("1", "Pedro", "Alvarez", "Bob", "Marley", "2022-02-22", "18:34", "Reservada", lista);
    Mono<List<PadecimientoTratamiento>> find = service.consultarPadecimientoTratamiento("1");
    StepVerifier.create(find).expectNext(cita.getTratamientosList());
  }
}
