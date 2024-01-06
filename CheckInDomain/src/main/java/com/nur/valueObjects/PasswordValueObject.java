package com.nur.valueObjects;

import core.BusinessRuleValidationException;
import core.ValueObject;
import rules.StringNotNullOrEmptyRule;

public class PasswordValueObject extends ValueObject {
  public String value;

  public String getValue() {
    return value;
  }

  public PasswordValueObject(String value) throws BusinessRuleValidationException {
    checkRule(new StringNotNullOrEmptyRule(value));
    this.value = value;
  }
}
