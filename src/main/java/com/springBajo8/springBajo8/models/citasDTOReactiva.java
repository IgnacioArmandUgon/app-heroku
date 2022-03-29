package com.springBajo8.springBajo8.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Document(collection = "citas")
public class citasDTOReactiva {
  @Id
  private String id = UUID.randomUUID().toString().substring(0, 10);
  private String idPaciente;
  private String nombrePaciente;
  private String apellidosPaciente;
  private String nombreMedico;
  private String apellidosMedico;
  private LocalDate fechaReservaCita;
  private LocalTime horaReservaCita;
  private String estadoReservaCita;
  private List<PadecimientoTratamiento> tratamientosList;


  public citasDTOReactiva() {
  }


  public citasDTOReactiva(String idPaciente, String nombrePaciente, String apellidosPaciente, String nombreMedico, String apellidosMedico, String fechaReservaCita, String horaReservaCita, String estadoReservaCita, List<PadecimientoTratamiento> tratamientosList) {
    this.idPaciente = idPaciente;
    this.nombrePaciente = nombrePaciente;
    this.apellidosPaciente = apellidosPaciente;
    this.nombreMedico = nombreMedico;
    this.apellidosMedico = apellidosMedico;
    this.fechaReservaCita = LocalDate.parse(fechaReservaCita);
    this.horaReservaCita = LocalTime.parse(horaReservaCita);
    this.estadoReservaCita = estadoReservaCita;
    this.tratamientosList = tratamientosList;
  }


  public citasDTOReactiva(String id, String idPaciente, String nombrePaciente, String apellidosPaciente, String nombreMedico, String apellidosMedico, String fechaReservaCita, String horaReservaCita, String estadoReservaCita, List<PadecimientoTratamiento> tratamientosList) {
    this.id = id;
    this.idPaciente = idPaciente;
    this.nombrePaciente = nombrePaciente;
    this.apellidosPaciente = apellidosPaciente;
    this.nombreMedico = nombreMedico;
    this.apellidosMedico = apellidosMedico;
    this.fechaReservaCita = LocalDate.parse(fechaReservaCita);
    this.horaReservaCita = LocalTime.parse(horaReservaCita);
    this.estadoReservaCita = estadoReservaCita;
    this.tratamientosList = tratamientosList;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdPaciente() {
    return idPaciente;
  }

  public void setIdPaciente(String idPaciente) {
    this.idPaciente = idPaciente;
  }

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  public String getApellidosPaciente() {
    return apellidosPaciente;
  }

  public void setApellidosPaciente(String apellidosPaciente) {
    this.apellidosPaciente = apellidosPaciente;
  }

  public String getNombreMedico() {
    return nombreMedico;
  }

  public void setNombreMedico(String nombreMedico) {
    this.nombreMedico = nombreMedico;
  }

  public String getApellidosMedico() {
    return apellidosMedico;
  }

  public void setApellidosMedico(String apellidosMedico) {
    this.apellidosMedico = apellidosMedico;
  }


  public List<PadecimientoTratamiento> getTratamientosList() {
      return tratamientosList;
  }

  public void setTratamientosList(List<PadecimientoTratamiento> tratamientosList) {
      this.tratamientosList = tratamientosList;
  }

  public LocalDate getFechaReservaCita() {
      return fechaReservaCita;
  }

  public void setFechaReservaCita(LocalDate fechaReservaCita) {
      this.fechaReservaCita = fechaReservaCita;
  }

  public LocalTime getHoraReservaCita() {
      return horaReservaCita;
  }

  public void setHoraReservaCita(LocalTime horaReservaCita) {
      this.horaReservaCita = horaReservaCita;
  }

  public String getEstadoReservaCita() {
      return estadoReservaCita;
  }

  public void setEstadoReservaCita(String estadoReservaCita) {
      this.estadoReservaCita = estadoReservaCita;
  }

}
