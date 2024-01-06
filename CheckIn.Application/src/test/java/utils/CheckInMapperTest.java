package utils;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import dtos.CheckInDto;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckInMapperTest {

  private CheckInMapper checkInMapper;

  @BeforeEach
  public void setUp() {
    checkInMapper = new CheckInMapper();
  }

  @Test
  public void testFromCheckInNotNull() throws BusinessRuleValidationException {
    CheckIn checkIn = createSampleCheckIn();
    CheckInDto checkInDto = CheckInMapper.from(checkIn);
    assertNotNull(checkInDto);

    List<Propiedad> availableSeats = checkIn.getAvaiblePropiedades();
    assertNotNull(checkInDto);
  }

  @Test
  public void testFromCheckInNull() {
    CheckInDto checkInDto = CheckInMapper.from(null);

    assertNull(checkInDto.checkInId);
  }

  private CheckIn createSampleCheckIn() throws BusinessRuleValidationException {
    CheckIn checkIn =
        new CheckIn(
            UUID.randomUUID(),
            Arrays.asList(new Propiedad(UUID.randomUUID().toString(), "casa", "HABILITADA", 100.0)),
            new Persona("juan", "perez", "123"));
    return checkIn;
  }
}
