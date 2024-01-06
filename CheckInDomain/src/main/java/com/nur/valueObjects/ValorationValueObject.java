package com.nur.valueObjects;

import core.BusinessRuleValidationException;
import core.ValueObject;
import rules.ValidPointsRule;

public class ValorationValueObject extends ValueObject {
  public int points;

  public int getPoints() {
    return points;
  }

  public ValorationValueObject(int points) throws BusinessRuleValidationException {
    checkRule(new ValidPointsRule(points));
    this.points = points;
  }
}
