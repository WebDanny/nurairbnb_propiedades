package com.nur.repositories;

import com.nur.model.TipoPropiedad;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface TipoPropiedadRepository {

  UUID update(TipoPropiedad tipo);

  List<TipoPropiedad> findTipoPropiedadById(UUID id) throws BusinessRuleValidationException;

  List<TipoPropiedad> getAll() throws BusinessRuleValidationException;
}
