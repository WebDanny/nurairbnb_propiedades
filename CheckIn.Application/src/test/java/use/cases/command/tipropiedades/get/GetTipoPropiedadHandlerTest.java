package use.cases.command.tipropiedades.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nur.model.TipoPropiedad;
import com.nur.repositories.TipoPropiedadRepository;
import core.BusinessRuleValidationException;
import dtos.TipoPropiedadDto;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetTipoPropiedadHandlerTest {

  private TipoPropiedadRepository tipoPropiedadRepository;
  private GetTipoPropiedadHandler getTipoPropiedadHandler;

  @BeforeEach
  public void setUp() {
    tipoPropiedadRepository = mock(TipoPropiedadRepository.class);
    getTipoPropiedadHandler = new GetTipoPropiedadHandler(tipoPropiedadRepository);
  }

  @Test
  public void testHandle() throws BusinessRuleValidationException {
    UUID mockId = UUID.randomUUID();
    List<TipoPropiedad> mockPropiedades = Arrays.asList(new TipoPropiedad());

    GetTipoPropiedadQuery query = new GetTipoPropiedadQuery(mockId.toString());
    when(tipoPropiedadRepository.findTipoPropiedadById(mockId)).thenReturn(mockPropiedades);

    List<TipoPropiedadDto> result = getTipoPropiedadHandler.handle(query);

    assertNotNull(result);
    assertEquals(mockPropiedades.size(), result.size());
  }
}
