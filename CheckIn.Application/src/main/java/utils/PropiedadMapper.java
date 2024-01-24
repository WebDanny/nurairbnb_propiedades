package utils;

import com.nur.model.Comodidad;
import com.nur.model.Propiedad;
import dtos.ComodidadDto;
import dtos.PropiedadDto;
import java.util.ArrayList;
import java.util.List;

public class PropiedadMapper {

  public static PropiedadDto from(Propiedad propiedad) {
    if (propiedad == null) return new PropiedadDto();
    return new PropiedadDto(
        propiedad.getId(),
        propiedad.getNombre() == null ? "" : propiedad.getNombre(),
        propiedad.getEstado() == null ? "" : propiedad.getEstado().toString(),
        propiedad.getPrecio() == 0.0 ? 0.0 : propiedad.getPrecio(),
        propiedad.getTipoPropiedad() == null ? null : propiedad.getTipoPropiedad().getId(),
        propiedad.getComodidades() == null ? null : fromComodidadDTO(propiedad.getComodidades()),
        propiedad.getDescripcion() == null ? null : propiedad.getDescripcion(),
        propiedad.getHora_checkout() == null ? null : propiedad.getHora_checkout(),
        propiedad.getHora_checkin() == null ? null : propiedad.getHora_checkin(),
        propiedad.getImage() == null ? null : propiedad.getImage());
  }

  public static List<ComodidadDto> fromComodidadDTO(List<Comodidad> comodidades) {
    if (comodidades == null) return new ArrayList<ComodidadDto>();

    List<ComodidadDto> comodidadDtoList = new ArrayList<>();

    for (int i = 0; i < comodidades.size(); i++) {

      ComodidadDto dto =
          new ComodidadDto(comodidades.get(i).getId(), comodidades.get(i).getNombre());
      comodidadDtoList.add(dto);
    }
    return comodidadDtoList;
  }
}
