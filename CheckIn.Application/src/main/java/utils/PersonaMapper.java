package utils;

import com.nur.model.Persona;
import dtos.PersonaDto;

public class PersonaMapper {

  public static PersonaDto from(Persona passanger) {
    if (passanger == null) return new PersonaDto();
    return new PersonaDto(
        passanger.getId() == null ? "" : passanger.getId().toString(),
        passanger.getName() == null ? "" : passanger.getName(),
        passanger.getLastname() == null ? "" : passanger.getLastname(),
        passanger.getCi() == null ? "" : passanger.getCi());
  }
}
