package com.nur.model;

import com.nur.event.PropiedadEliminado;
import com.nur.event.PropiedadHabilitado;
import com.nur.event.PropiedadModificada;
import core.AggregateRoot;
import core.BusinessRuleValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Propiedad extends AggregateRoot {
  /// private UUID Id;
  private String nombre;
  private Estado estado;
  private double precio;

  private TipoPropiedad tipoPropiedad;
  private List<CaracteristicasPropiedad> caracteristicasPropiedades;

  private TipoPropiedad getTipoPropiedad() {
    return tipoPropiedad;
  }

  public Propiedad() {
    this.tipoPropiedad = new TipoPropiedad();
    this.caracteristicasPropiedades = new ArrayList<>();
    // this.Id = id;
  }

  public Propiedad(String id, String nombre, String estado, double precio)
      throws BusinessRuleValidationException {
    this.id = UUID.fromString(id);
    this.nombre = nombre;
    if (estado.equals("HABILITADO")) this.estado = Estado.HABILITADO;
    else this.estado = Estado.INHABILITADO;
    this.precio = precio;
    // this.tipoPropiedad = new TipoPropiedad();
    // this.caracteristicasPropiedades = new ArrayList<>();
  }

  public void agregarCaracteristica(
      UUID id,
      boolean cocina,
      boolean wifi,
      boolean estacionamiento,
      boolean camaraSeguridad,
      boolean detectorHumo,
      boolean secadoraPelo,
      boolean shampoo,
      boolean aguaCaliente)
      throws Exception {
    if (caracteristicasPropiedades.stream().anyMatch(item -> item.id == id)) {
      throw new Exception("Esa caracteristica ya existe en la propiedad");
    }
    CaracteristicasPropiedad item =
        new CaracteristicasPropiedad(
            id,
            cocina,
            wifi,
            estacionamiento,
            camaraSeguridad,
            detectorHumo,
            secadoraPelo,
            shampoo,
            aguaCaliente);
    caracteristicasPropiedades.add(item);
  }

  public void agregarTipoPropiedad(UUID IdTipo, String descripcion) {
    TipoPropiedad tipo = new TipoPropiedad(IdTipo, descripcion);
  }

  public void crearPropiedad() {
    PropiedadHabilitado event = new PropiedadHabilitado(this, new Date());
    addDomainEvent(event);
  }

  public void eliminarPropiedad(UUID Id) {
    PropiedadEliminado event = new PropiedadEliminado(this, new Date());
    this.estado = Estado.INHABILITADO;
    addDomainEvent(event);
  }

  public void modificarPropiedad(UUID Id, String nombre, double precio) {
    PropiedadModificada event = new PropiedadModificada(this, new Date());
    this.nombre = nombre;
    this.precio = precio;
    addDomainEvent(event);
  }

  public String getNombre() {
    return nombre;
  }

  public Estado getEstado() {
    return estado;
  }

  public double getPrecio() {
    return precio;
  }

  public List<CaracteristicasPropiedad> getCaracteristicasPropiedades() {
    return caracteristicasPropiedades;
  }
}
