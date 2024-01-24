package com.nur.repositories;

import com.nur.model.Comodidad;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface ComodidadRepository {

  UUID update(Comodidad comodidad);

  List<Comodidad> findComodidadById(UUID id) throws BusinessRuleValidationException;

  List<Comodidad> getAll() throws BusinessRuleValidationException;
}
