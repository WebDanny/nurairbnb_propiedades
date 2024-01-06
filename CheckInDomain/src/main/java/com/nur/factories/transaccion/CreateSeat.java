package com.nur.factories.transaccion;

import com.nur.model.Transaccion;
import core.BusinessRuleValidationException;
import java.util.UUID;

public class CreateSeat implements TransaccionFactory {

  @Override
  public Transaccion create(String code, String descripcion, double monto)
      throws BusinessRuleValidationException {
    return new Transaccion(UUID.fromString(code), descripcion, monto);
  }
}
