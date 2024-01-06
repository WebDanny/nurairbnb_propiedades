package use.cases.command.persona;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nur.model.Persona;
import com.nur.repositories.PersonaRepository;
import core.BusinessRuleValidationException;
import dtos.PersonaDto;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use.cases.command.persona.get.persona.GetPersonaHandler;
import use.cases.command.persona.get.persona.GetPersonaQuery;

public class GetPersonaHandlerTest {
  private PersonaRepository personaRepository;
  private GetPersonaHandler getPersonaHandler;

  @BeforeEach
  public void setUp() {
    personaRepository = mock(PersonaRepository.class);
    getPersonaHandler = new GetPersonaHandler(personaRepository);
  }

  @Test
  public void testHandle() throws BusinessRuleValidationException {
    List<Persona> mockPersonas = Arrays.asList(new Persona("Juan", "Perez", "1234"));

    when(personaRepository.getAll()).thenReturn(mockPersonas);
    List<PersonaDto> result = getPersonaHandler.handle(new GetPersonaQuery());
    assertNotNull(result);
    assertEquals(mockPersonas.size(), result.size());
  }
}
