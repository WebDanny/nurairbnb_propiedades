package com.nur.model;

import core.Entity;
import java.util.UUID;

public class Comodidad extends Entity {
  private UUID Id;
  private String nombre;

  public Comodidad() {}

  public Comodidad(UUID id, String nombreTipo) {
    Id = id;
    this.nombre = nombreTipo;
  }

  @Override
  public UUID getId() {
    return Id;
  }

  public String getNombre() {
    return nombre;
  }
}
