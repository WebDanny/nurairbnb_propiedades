package dtos;

import java.util.List;
import java.util.UUID;

public class PropiedadDto {
  public UUID id;
  public String nombre;
  public String estado;
  public double precio;
  public UUID tipoPropiedadId;

  public List<ComodidadDto> comodidades;
  public String descripcion;
  public String hora_checkout;

  public String hora_checkin;

  public String image;

  public PropiedadDto() {}

  public PropiedadDto(
      UUID id,
      String nombre,
      String estado,
      double precio,
      UUID tipoPropiedadId,
      List<ComodidadDto> comodidades,
      String descripcion,
      String hora_checkout,
      String hora_checkin,
      String image) {
    this.id = id;
    this.nombre = nombre;
    this.estado = estado;
    this.precio = precio;
    this.tipoPropiedadId = tipoPropiedadId;
    this.comodidades = comodidades;
    this.descripcion = descripcion;
    this.hora_checkout = hora_checkout;
    this.hora_checkin = hora_checkin;
    this.image = image;
  }
}
