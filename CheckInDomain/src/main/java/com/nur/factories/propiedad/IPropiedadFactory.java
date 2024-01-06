package com.nur.factories.propiedad;

import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;

public interface IPropiedadFactory {
  Propiedad create(String id, String nombre, String estado, double precio)
      throws BusinessRuleValidationException;
}
