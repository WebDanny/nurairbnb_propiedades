package com.nur.valueObjects;

import core.BusinessRuleValidationException;
import core.ValueObject;
import rules.ValidEmail;

public class EmailValueObject extends ValueObject {
  public String value;

  public String getValue() {
    return value;
  }

  public EmailValueObject(String value) throws BusinessRuleValidationException {
    checkRule(new ValidEmail(value));
    this.value = value;
  }
}
