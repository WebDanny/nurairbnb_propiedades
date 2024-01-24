package com.nur.factories.comodidad;

import com.nur.model.Comodidad;
import core.BusinessRuleValidationException;
import java.util.UUID;

public class ComodidadFactory implements IComodidadFactory {

  @Override
  public Comodidad create(UUID id, String nombre) throws BusinessRuleValidationException {
    return new Comodidad(id, nombre);
  }
}
