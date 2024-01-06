package com.nur.repositories;

import com.nur.model.CheckIn;
import core.BusinessRuleValidationException;
import java.util.UUID;

public interface CheckInRepository {
  UUID update(CheckIn checkIn);

  CheckIn get(UUID id);

  CheckIn findByPersonAndId(UUID passenger, UUID checkIn) throws BusinessRuleValidationException;
}
