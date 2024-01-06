package rules;


import core.BusinessRule;

public class ValidPointsRule implements BusinessRule {
    public int value;

    public ValidPointsRule(int value) {
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return this.value < 0;
    }

    @Override
    public String getMessage() {
        return "Points invalidos";
    }
}
