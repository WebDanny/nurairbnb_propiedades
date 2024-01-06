package factories;

import com.nur.factories.check.in.CreateCheckIn;
import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreatesCheckInTest {
  private CreateCheckIn checkInFactory;

  @BeforeEach
  void setUp() {
    checkInFactory = new CreateCheckIn();
  }

  @Test
  void testCreateCheckIn() throws BusinessRuleValidationException {

    UUID flightId = UUID.fromString("a39c0404-50f9-11ee-be56-0242ac120002");
    List<Propiedad> availableProperties = new ArrayList<>();
    Persona persona = new Persona("John", "Doe", "123");

    CheckIn checkIn =
        checkInFactory.create(
            UUID.fromString("a39c0404-50f9-11ee-be56-0242ac120002"), availableProperties, persona);

    Assertions.assertNotNull(checkIn);
    Assertions.assertEquals(availableProperties, checkIn.getAvaiblePropiedades());
    Assertions.assertEquals(persona, checkIn.getPersona());
  }
}
