package com.springBajo8.springBajo8.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.springBajo8.springBajo8.models.citasDTOReactiva;
import com.springBajo8.springBajo8.services.CitasReactivaService;
import com.springBajo8.springBajo8.models.PadecimientoTratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/citasReactiva")
public class    citasReactivaController {

  @Autowired
  private CitasReactivaService icitasReactivaService;
  
  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
      return this.icitasReactivaService.save(citasDTOReactiva);
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
      return this.icitasReactivaService.delete(id)
              .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
              .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

  }

  @GetMapping("/idPaciente/{idPaciente}")
  public Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
      return this.icitasReactivaService.findByIdPaciente(idPaciente);
  }

  @PutMapping("/{id}")
  public Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

  @GetMapping(value = "")
  public Flux<citasDTOReactiva> findAll() {
      return this.icitasReactivaService.findAll();
  }

    @GetMapping("/{id}/consultarTratamiento")
    public Mono<List<PadecimientoTratamiento>> verTratamiento(@PathVariable("id") String id) {
        return this.icitasReactivaService.consultarPadecimientoTratamiento(id);
    }


  @PutMapping("/{id}/cancelar")
  public Mono<citasDTOReactiva> cancelarCitaById(@PathVariable("id") String id) {
      return this.icitasReactivaService.cancelarCita(id);
  }

  @GetMapping("/consultarFechaHora/{fecha}/{hora}")
  public Flux<citasDTOReactiva> consultarFechaHora(@PathVariable("fecha") String fecha, @PathVariable("hora") String hora) {
      LocalDate fechaParseada = LocalDate.parse(fecha);
      LocalTime horaParseada = LocalTime.parse(hora);
      return this.icitasReactivaService.consultarFechaYHora(fechaParseada, horaParseada);
  }

  @GetMapping("/{id}/consultarMedico")
  public Mono<citasDTOReactiva> consultarMedico(@PathVariable("id") String id) {
      return this.icitasReactivaService.consultarMedico(id);
  }



}
