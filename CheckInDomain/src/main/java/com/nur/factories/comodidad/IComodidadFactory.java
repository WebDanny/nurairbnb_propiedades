package com.nur.factories.comodidad;

import com.nur.model.Comodidad;
import core.BusinessRuleValidationException;
import java.util.UUID;

public interface IComodidadFactory {
  Comodidad create(UUID id, String nombre) throws BusinessRuleValidationException;
}
