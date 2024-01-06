package com.nur.factories.check.in;

import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;
import java.util.List;
import java.util.UUID;

public interface CheckInFactory {
  CheckIn create(UUID flightId, List<Propiedad> avaiblePropiedades, Persona passanger);
}
