package infraestructure.utils;

import com.nur.annotations.Generated;
import com.nur.model.MetodoPago;
import core.BusinessRuleValidationException;
import infraestructure.model.MetodoPagoJpaModel;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Generated
public class MetodoPagoUtils {

  public static MetodoPagoJpaModel baggageToJpaEntity(MetodoPago baggage) {

    MetodoPagoJpaModel model = new MetodoPagoJpaModel();
    model.setDetalle(baggage.getDetalle());
    model.setTipo(baggage.getType().toString());
    model.setId(baggage.getId());
    return model;
  }

  public static List<MetodoPagoJpaModel> baggagesToJpaEntities(List<MetodoPago> baggages) {
    if (baggages == null) return Collections.emptyList();
    return baggages.stream()
        .map((MetodoPago baggage) -> baggageToJpaEntity(baggage))
        .collect(Collectors.toList());
  }

  public static MetodoPago jpaToBaggage(MetodoPagoJpaModel jpaModel)
      throws BusinessRuleValidationException {
    return new MetodoPago(jpaModel.getDetalle(), jpaModel.getTipo());
  }
}
