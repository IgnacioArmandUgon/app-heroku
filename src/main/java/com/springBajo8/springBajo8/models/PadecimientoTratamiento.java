package com.springBajo8.springBajo8.models;

public class PadecimientoTratamiento {
  
private  String padecimiento;
private  String tratamiento;

  public PadecimientoTratamiento(String padecimiento, String tratamiento) {
      this.padecimiento = padecimiento;
      this.tratamiento = tratamiento;
  }

  public PadecimientoTratamiento() {
  }

  public String getPadecimiento() {
      return padecimiento;
  }

  public void setPadecimiento(String padecimiento) {
      this.padecimiento = padecimiento;
  }

  public String getTratamiento() {
      return tratamiento;
  }

  public void setTratamiento(String tratamiento) {
      this.tratamiento = tratamiento;
  }

  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("padecimiento = ");
      sb.append(getPadecimiento());
      sb.append(", tratamiento = ");
      sb.append(getTratamiento());

      return sb.toString();
  }
}
