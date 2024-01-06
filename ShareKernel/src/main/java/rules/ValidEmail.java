package rules;

import core.BusinessRule;

public class ValidEmail implements BusinessRule {
    public String _email;

    public ValidEmail(String _email) {
        this._email = _email;
    }

    @Override
    public boolean isValid() {
        return _email.isEmpty();
    }

    @Override
    public String getMessage() {
        return "Invalid email person";
    }
}
