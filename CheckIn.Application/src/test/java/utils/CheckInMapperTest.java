package utils;

import static org.junit.jupiter.api.Assertions.*;

import dtos.CheckInDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckInMapperTest {

  private CheckInMapper checkInMapper;

  @BeforeEach
  public void setUp() {
    checkInMapper = new CheckInMapper();
  }

  /*@Test
  public void testFromCheckInNotNull() throws BusinessRuleValidationException {
   // CheckIn checkIn = createSampleCheckIn();
    CheckInDto checkInDto = CheckInMapper.from(checkIn);
    assertNotNull(checkInDto);

    List<Propiedad> availableSeats = checkIn.getAvaiblePropiedades();
    assertNotNull(checkInDto);
  }*/

  @Test
  public void testFromCheckInNull() {
    CheckInDto checkInDto = CheckInMapper.from(null);

    assertNull(checkInDto.checkInId);
  }

  /*private CheckIn createSampleCheckIn() throws BusinessRuleValidationException {
    CheckIn checkIn =
        new CheckIn(
            UUID.randomUUID(),
            Arrays.asList(new Propiedad(UUID.randomUUID().toString(), "casa", "HABILITADA", 100.0)),
            new Persona("juan", "perez", "123"));
    return checkIn;
  }*/
}
