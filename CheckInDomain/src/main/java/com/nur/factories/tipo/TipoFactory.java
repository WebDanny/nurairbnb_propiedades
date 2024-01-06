package com.nur.factories.tipo;

import com.nur.model.TipoPropiedad;
import core.BusinessRuleValidationException;
import java.util.UUID;

public interface TipoFactory {
  TipoPropiedad create(UUID id, String nombre) throws BusinessRuleValidationException;
}
