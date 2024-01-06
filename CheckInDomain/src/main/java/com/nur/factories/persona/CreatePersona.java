package com.nur.factories.persona;

import com.nur.model.Persona;
import core.BusinessRuleValidationException;

public class CreatePersona implements PersonaFactory {

  @Override
  public Persona create(String name, String lastname, String ci)
      throws BusinessRuleValidationException {
    return new Persona(name, lastname, ci);
  }
}
