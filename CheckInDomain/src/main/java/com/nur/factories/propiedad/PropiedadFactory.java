package com.nur.factories.propiedad;

import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;

public class PropiedadFactory implements IPropiedadFactory {

  @Override
  public Propiedad create(String id, String nombre, String estado, double precio)
      throws BusinessRuleValidationException {
    return new Propiedad(id, nombre, estado, precio);
  }
}
