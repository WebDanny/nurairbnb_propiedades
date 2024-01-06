package com.nur.factories.tipo;

import com.nur.model.TipoPropiedad;
import core.BusinessRuleValidationException;
import java.util.UUID;

public class TipoPropiedadFactory implements TipoFactory {

  @Override
  public TipoPropiedad create(UUID id, String nombre) throws BusinessRuleValidationException {
    return new TipoPropiedad(id, nombre);
  }
}
