package com.nur.repositories;

import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.List;
import java.util.UUID;

public interface PropiedadRepository {

  UUID update(Propiedad propiedad);

  List<Propiedad> findByIdAndEstado(UUID id, String estado) throws BusinessRuleValidationException;

  List<Propiedad> findPropiedadById(UUID id) throws BusinessRuleValidationException;

  List<Propiedad> getAll() throws BusinessRuleValidationException;
}
