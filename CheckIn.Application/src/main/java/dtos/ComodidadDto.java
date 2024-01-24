package dtos;

import java.util.UUID;

public class ComodidadDto {
  public UUID id;
  public String nombre;

  public ComodidadDto() {}

  public ComodidadDto(UUID id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }
}
