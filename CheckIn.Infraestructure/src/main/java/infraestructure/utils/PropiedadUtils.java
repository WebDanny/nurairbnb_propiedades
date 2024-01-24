package infraestructure.utils;

import com.nur.annotations.Generated;
import com.nur.model.Comodidad;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import infraestructure.model.ComodidadJpaModel;
import infraestructure.model.PropiedadJpaModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Generated
public class PropiedadUtils {

  public static PropiedadJpaModel propiedadToJpaEntity(Propiedad propiedad) {
    if (propiedad == null) return null;
    PropiedadJpaModel propiedadJpaModel = new PropiedadJpaModel();
    propiedadJpaModel.setId(propiedad.getId());
    propiedadJpaModel.setNombre(propiedad.getNombre());
    propiedadJpaModel.setEstado(propiedad.getEstado().toString());
    propiedadJpaModel.setPrecio(propiedad.getPrecio());
    return propiedadJpaModel;
  }

  public static List<PropiedadJpaModel> propiedadToJpaEntities(List<Propiedad> propiedades) {
    if (propiedades == null) return Collections.emptyList();
    return propiedades.stream()
        .map(PropiedadUtils::propiedadToJpaEntity)
        .collect(Collectors.toList());
  }

  public static Propiedad jpaModelToPropiedad(PropiedadJpaModel jpaModel)
      throws BusinessRuleValidationException {
    return new Propiedad(
        String.valueOf(jpaModel.getId()),
        jpaModel.getNombre(),
        jpaModel.getEstado(),
        jpaModel.getPrecio(),
        jpaModel.getTipoPropiedadId(),
        ComodidadJpaModelTocomodidad(jpaModel.getComodidades()),
        jpaModel.getHora_checkin(),
        jpaModel.getHora_checkout(),
        jpaModel.getDescripcion(),
        null);
  }

  public static List<Comodidad> ComodidadJpaModelTocomodidad(List<ComodidadJpaModel> jpaModel)
      throws BusinessRuleValidationException {
    List<Comodidad> comodidadList = new ArrayList<>();
    if (jpaModel == null) {
      return comodidadList;
    }
    for (int i = 0; i < jpaModel.size(); i++) {
      comodidadList.add(new Comodidad(jpaModel.get(i).getId(), jpaModel.get(i).getNombre()));
    }
    return comodidadList;
  }
}
