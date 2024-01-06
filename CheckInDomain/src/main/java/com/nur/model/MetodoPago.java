package com.nur.model;

import core.BusinessRuleValidationException;
import core.Entity;
import java.util.UUID;

public class MetodoPago extends Entity {

  private String detalle;
  private MetodoTipo type;

  public MetodoPago(String detalle, String tipo) throws BusinessRuleValidationException {
    this.id = UUID.randomUUID();
    this.detalle = detalle;
    if (tipo == "T") type = MetodoTipo.TARJETA;
    else type = MetodoTipo.PAYPAL;
  }

  public String getDetalle() {
    return detalle;
  }

  public MetodoTipo getType() {
    return type;
  }
}
