package com.nur.repositories;

import com.nur.model.Persona;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface PersonaRepository {
  UUID update(Persona passanger);

  Persona get(UUID id) throws BusinessRuleValidationException;

  List<Persona> getAll() throws BusinessRuleValidationException;
}
