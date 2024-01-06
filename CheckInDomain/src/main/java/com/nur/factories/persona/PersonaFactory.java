package com.nur.factories.persona;

import com.nur.model.Persona;
import core.BusinessRuleValidationException;

public interface PersonaFactory {
  Persona create(String name, String lastname, String ci) throws BusinessRuleValidationException;
}
