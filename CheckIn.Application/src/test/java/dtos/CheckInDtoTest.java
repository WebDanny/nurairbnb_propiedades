package dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CheckInDtoTest {
  @Test
  public void testConstructorAndGetters() {
    String checkInId = "12345";
    String propiedadId = "98765";
    Date date = new Date();
    PropiedadDto propiedad = new PropiedadDto();
    List<PropiedadDto> availablePropiedades = List.of(new PropiedadDto(), new PropiedadDto());
    PersonaDto persona = new PersonaDto();

    CheckInDto checkIn =
        new CheckInDto(checkInId, propiedadId, date, propiedad, availablePropiedades, persona);

    assertEquals(checkInId, checkIn.checkInId);
    assertEquals(propiedadId, checkIn.propiedadId);
    assertEquals(date, checkIn.date);
    assertEquals(propiedad, checkIn.propiedad);
    assertEquals(availablePropiedades, checkIn.avaiblePropiedades);
    assertEquals(persona, checkIn.persona);
  }

  @Test
  public void testDefaultConstructor() {
    CheckInDto checkIn = new CheckInDto();

    assertNull(checkIn.checkInId);
    assertNull(checkIn.propiedadId);
    assertNull(checkIn.date);
    assertNull(checkIn.propiedad);
    assertNull(checkIn.avaiblePropiedades);
    assertNull(checkIn.persona);
  }
}
