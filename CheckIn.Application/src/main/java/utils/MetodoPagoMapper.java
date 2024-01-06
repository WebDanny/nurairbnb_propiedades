package utils;

import com.nur.model.MetodoPago;
import core.BusinessRuleValidationException;
import dtos.MetodoPagoDto;

public final class MetodoPagoMapper {

  public static MetodoPagoDto from(MetodoPago baggage) {
    if (baggage == null) return new MetodoPagoDto();
    return new MetodoPagoDto(baggage.getDetalle(), baggage.getType().toString());
  }

  public static MetodoPago from(MetodoPagoDto baggageDto) throws BusinessRuleValidationException {
    return new MetodoPago(baggageDto.detalle, baggageDto.tipo);
  }
}
