import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.danny.checkinapi.controllers.TipoPropiedadController;
import dtos.TipoPropiedadDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TipoPropiedadControllerTest {

  @Mock Pipeline pipeline;

  private static final UUID TIPO_ID = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetTipoPropiedadById() {
    List<TipoPropiedadDto> tipoDtos = new ArrayList<>();
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(tipoDtos);

    TipoPropiedadController controller = new TipoPropiedadController(pipeline);
    List<TipoPropiedadDto> response = controller.getTipoPropiedad(TIPO_ID.toString());
    assertNotNull(response);
  }

  @Test
  void testListTipoPropiedad() {
    List<TipoPropiedadDto> tipoDtos = new ArrayList<>();
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(tipoDtos);

    TipoPropiedadController controller = new TipoPropiedadController(pipeline);
    List<TipoPropiedadDto> response = controller.getListAllTipoPropiedades();
    assertNotNull(response);
  }

  @Test
  void testCreateTipoPropiedad() {
    TipoPropiedadDto tipoDtos = new TipoPropiedadDto();
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(tipoDtos);

    TipoPropiedadController controller = new TipoPropiedadController(pipeline);
    TipoPropiedadDto response = controller.createTipo(new TipoPropiedadDto());
    assertNotNull(response);
  }
}
