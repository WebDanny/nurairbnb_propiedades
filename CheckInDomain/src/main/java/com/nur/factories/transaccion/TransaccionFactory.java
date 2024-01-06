package com.nur.factories.transaccion;

import com.nur.model.Transaccion;
import core.BusinessRuleValidationException;

public interface TransaccionFactory {
  Transaccion create(String code, String descripcion, double monto)
      throws BusinessRuleValidationException;
}
