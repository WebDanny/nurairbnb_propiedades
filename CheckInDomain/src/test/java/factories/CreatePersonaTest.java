package factories;

import com.nur.factories.persona.CreatePersona;
import com.nur.model.Persona;
import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreatePersonaTest {
  private CreatePersona personaFactory;

  @BeforeEach
  public void setUp() {
    personaFactory = new CreatePersona();
  }

  @Test
  public void testCreatePersona() throws BusinessRuleValidationException {
    String name = "John";
    String lastName = "Doe";
    String ci = "1234567890";

    Persona persona = personaFactory.create(name, lastName, ci);

    Assertions.assertNotNull(persona);
    Assertions.assertEquals(name, persona.getName());
    Assertions.assertEquals(lastName, persona.getLastname());
    Assertions.assertEquals(ci, persona.getCi());
  }
}
