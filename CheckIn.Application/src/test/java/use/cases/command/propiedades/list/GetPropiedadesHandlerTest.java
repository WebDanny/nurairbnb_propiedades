package use.cases.command.propiedades.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nur.model.Propiedad;
import com.nur.repositories.PropiedadRepository;
import core.BusinessRuleValidationException;
import dtos.PropiedadDto;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetPropiedadesHandlerTest {

  private PropiedadRepository propiedadRepository;
  private GetPropiedadesHandler getPropiedadesHandler;

  @BeforeEach
  public void setUp() {
    propiedadRepository = mock(PropiedadRepository.class);
    getPropiedadesHandler = new GetPropiedadesHandler(propiedadRepository);
  }

  @Test
  public void testHandle() throws BusinessRuleValidationException {
    List<Propiedad> mockPropiedades =
        Arrays.asList(
            new Propiedad(
                UUID.randomUUID().toString(),
                "Casa",
                "HABILITADA",
                100.0,
                null,
                null,
                null,
                null,
                null,
                null));
    when(propiedadRepository.getAll()).thenReturn(mockPropiedades);

    List<PropiedadDto> result = getPropiedadesHandler.handle(new GetPropiedadesQuery());

    assertNotNull(result);
    assertEquals(mockPropiedades.size(), result.size());
  }
}
