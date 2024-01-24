package infraestructure.utils;

import com.nur.model.Comodidad;
import com.nur.model.TipoPropiedad;
import core.BusinessRuleValidationException;
import infraestructure.model.ComodidadJpaModel;
import java.util.Collections;
import java.util.List;

public class ComodidadUtils {

  public static ComodidadJpaModel tipoToJpaEntity(Comodidad comodidad) {
    if (comodidad == null) return null;
    ComodidadJpaModel comodidadJpaModel = new ComodidadJpaModel();
    comodidadJpaModel.setId(comodidad.getId());
    comodidadJpaModel.setNombre(comodidad.getNombre());
    return comodidadJpaModel;
  }

  public static List<ComodidadJpaModel> seatsToJpaEntities(List<TipoPropiedad> tipo) {
    if (tipo == null) return Collections.emptyList();
    return null; // tipo.stream().map(ComodidadUtils::tipoToJpaEntity).collect(Collectors.toList());
  }

  public static Comodidad jpaModelToTipoPropiedad(ComodidadJpaModel jpaModel)
      throws BusinessRuleValidationException {
    return new Comodidad(jpaModel.getId(), jpaModel.getNombre());
  }
}
