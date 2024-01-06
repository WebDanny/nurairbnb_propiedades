package com.nur.repositories;

import com.nur.model.MetodoPago;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface MetodoPagoRepository {
  UUID update(MetodoPago baggage);

  List<MetodoPago> findMetodoPagoById(UUID metodoId) throws BusinessRuleValidationException;
}
