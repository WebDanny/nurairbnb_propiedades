package com.nur.factories.propiedad;

import com.nur.model.Comodidad;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public class PropiedadFactory implements IPropiedadFactory {

  @Override
  public Propiedad create(
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
      throws BusinessRuleValidationException {
    return new Propiedad(
        id,
        nombre,
        estado,
        precio,
        tipoPropiedadId,
        comodidades,
        check_in,
        check_out,
        description,
        image);
  }
}
