package com.nur.factories.propiedad;

import com.nur.model.Comodidad;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface IPropiedadFactory {
  Propiedad create(
      String id,
      String nombre,
      String estado,
      double precio,
      UUID tipoPropiedadId,
      List<Comodidad> comodidades,
      String check_in,
      String check_out,
      String description,
      String image)
      throws BusinessRuleValidationException;
}
