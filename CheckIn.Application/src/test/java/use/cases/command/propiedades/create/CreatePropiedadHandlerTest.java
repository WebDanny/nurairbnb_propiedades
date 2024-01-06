package use.cases.command.propiedades.create;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nur.model.Propiedad;
import com.nur.repositories.PropiedadRepository;
import dtos.PropiedadDto;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatePropiedadHandlerTest {

  private PropiedadRepository propiedadRepository;
  private CreatePropiedadHandler createPropiedadHandler;

  @BeforeEach
  public void setUp() {
    propiedadRepository = mock(PropiedadRepository.class);
    createPropiedadHandler = new CreatePropiedadHandler(propiedadRepository);
  }

  @Test
  public void testHandle() {
    PropiedadDto mockPropiedadDto =
        new PropiedadDto(UUID.randomUUID(), "casa", "HABILITADA", 100.0);
    CreatePropiedadCommand command = new CreatePropiedadCommand(mockPropiedadDto);
    when(propiedadRepository.update(any(Propiedad.class))).thenReturn(UUID.randomUUID());

    PropiedadDto result = createPropiedadHandler.handle(command);
    assertNotNull(result);
  }
}
