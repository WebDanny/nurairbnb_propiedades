package use.cases.command.tipropiedades.list;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetListTipoPropiedadesHandlerTest {

  private TipoPropiedadRepository tipoPropiedadRepository;
  private GetListTipoPropiedadesHandler getListTipoPropiedadesHandler;

  @BeforeEach
  public void setUp() {
    tipoPropiedadRepository = mock(TipoPropiedadRepository.class);
    getListTipoPropiedadesHandler = new GetListTipoPropiedadesHandler(tipoPropiedadRepository);
  }

  @Test
  public void testHandle() throws BusinessRuleValidationException {
    List<TipoPropiedad> mockTipos = Arrays.asList(new TipoPropiedad());
    when(tipoPropiedadRepository.getAll()).thenReturn(mockTipos);
    List<TipoPropiedadDto> result =
        getListTipoPropiedadesHandler.handle(new GetListTipoPropiedadesQuery());
    assertNotNull(result);
    assertEquals(mockTipos.size(), result.size());
  }
}
