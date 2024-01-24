package utils;

import com.nur.model.Comodidad;
import dtos.ComodidadDto;
import java.util.ArrayList;
import java.util.List;

public final class ComodidadMapper {

  public static List<Comodidad> from(List<ComodidadDto> tipo) {
    List<Comodidad> comodidadDtoList = new ArrayList<>();
    if (tipo == null) {
      return comodidadDtoList;
    }
    for (int i = 0; i < tipo.size(); i++) {
      comodidadDtoList.add(new Comodidad(tipo.get(i).id, tipo.get(i).nombre));
    }

    return comodidadDtoList;
  }
}
