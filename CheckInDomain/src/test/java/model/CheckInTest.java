package model;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckInTest {
  private CheckIn checkIn;
  private UUID propiedadId;
  private List<Propiedad> availablePropiedades;
  private Persona persona;

  @BeforeEach
  public void setUp() throws BusinessRuleValidationException {
    propiedadId = UUID.randomUUID();
    availablePropiedades = new ArrayList<>();
    persona = new Persona("juan", "peres", "123");
    checkIn = new CheckIn(propiedadId, availablePropiedades, persona);
  }

  @Test
  void testAssignPropiedad() throws BusinessRuleValidationException {
    UUID propiedadCode = UUID.randomUUID();
    Propiedad propiedad =
        new Propiedad(String.valueOf(propiedadCode), "Test Propiedad", "HABILITADO", 1000.0);
    availablePropiedades.add(propiedad);

    checkIn.assignPropiedad(propiedadCode);

    assertEquals(propiedad, checkIn.getPropiedad());
    assertNotNull(checkIn.getDomainEvents().get(0));
    assertDoesNotThrow(() -> checkIn.assignPropiedad(UUID.randomUUID()));
  }

  @Test
  void testCompleteCheckIn() throws BusinessRuleValidationException {
    checkIn.completeCheckIn();

    assertEquals(0, checkIn.getDomainEvents().size());
    UUID propiedadCode = UUID.randomUUID();
    Propiedad propiedad =
        new Propiedad(String.valueOf(propiedadCode), "Test Propiedad", "HABILITADO", 1000.0);
    availablePropiedades.add(propiedad);
    checkIn.assignPropiedad(propiedadCode);
    checkIn.completeCheckIn();

    assertEquals(3, checkIn.getDomainEvents().size());
  }
}
