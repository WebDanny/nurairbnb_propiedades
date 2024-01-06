package com.nur.repositories;

import com.nur.model.Transaccion;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository {
  UUID update(Transaccion transaccion);

  // List<Transaccion> findByFlightIdAndStatus(UUID flightId, String status)
  // throws BusinessRuleValidationException;

  List<Transaccion> findByTransactionCode(UUID flightId) throws BusinessRuleValidationException;
}
