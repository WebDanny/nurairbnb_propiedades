package utils;

import com.nur.model.CheckIn;
import dtos.CheckInDto;
import dtos.PropiedadDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckInMapper {
  public static CheckInDto from(CheckIn checkIn) {
    if (checkIn == null) return new CheckInDto();
    List<PropiedadDto> availableSeats =
        checkIn.getAvaiblePropiedades() == null
            ? new ArrayList<>()
            : checkIn.getAvaiblePropiedades().stream()
                .map(PropiedadMapper::from)
                .collect(Collectors.toList());

    return new CheckInDto(
        checkIn.getId().toString(),
        checkIn.getPropiedadId().toString(),
        checkIn.getDate(),
        PropiedadMapper.from(checkIn.getPropiedad()),
        availableSeats,
        PersonaMapper.from(checkIn.getPersona()));
  }
}
