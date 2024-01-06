package event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.nur.event.CheckInCompleted;
import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CheckInCompletedTest {

  @Test
  void testGetCheckIn() throws BusinessRuleValidationException {
    CheckIn checkIn =
        new CheckIn(
            UUID.randomUUID(), new ArrayList<Propiedad>(), new Persona("juan", "perez", "123"));

    CheckInCompleted completed = new CheckInCompleted(checkIn);

    assertEquals(checkIn, completed.getCheckIn());
  }

  @Test
  public void testDateInheritance() throws BusinessRuleValidationException {
    CheckIn checkIn =
        new CheckIn(
            UUID.randomUUID(), new ArrayList<Propiedad>(), new Persona("juan", "perez", "123"));

    CheckInCompleted completed = new CheckInCompleted(checkIn);
    assertNotNull(completed);
  }
}
