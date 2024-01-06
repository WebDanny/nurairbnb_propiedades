import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.danny.checkinapi.controllers.PropiedadController;
import dtos.PropiedadDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PropiedadControllerTest {

  @Mock Pipeline pipeline;

  private static final UUID PROPIEDAD_ID = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetPropiedadById() {
    List<PropiedadDto> propiedadDtos = new ArrayList<>();
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(propiedadDtos);

    PropiedadController controller = new PropiedadController(pipeline);
    List<PropiedadDto> response = controller.getPropiedad(PROPIEDAD_ID.toString());
    assertNotNull(response);
  }

  @Test
  void testListPropiedad() {
    List<PropiedadDto> propiedadDtos = new ArrayList<>();
    propiedadDtos.add(new PropiedadDto(UUID.randomUUID(), "casa", "HABILITADO", 100.0));
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(propiedadDtos);

    PropiedadController controller = new PropiedadController(pipeline);
    List<PropiedadDto> response = controller.getListAllPropiedades();
    assertNotNull(response);
  }

  @Test
  void testCreatePropiedad() {
    PropiedadDto propiedadDtos = new PropiedadDto(UUID.randomUUID(), "casa", "HABILITADO", 100.0);

    when(pipeline.send((Command<Object>) anyObject())).thenReturn(propiedadDtos);

    PropiedadController controller = new PropiedadController(pipeline);
    PropiedadDto response = controller.createPropiedad(new PropiedadDto());
    assertNotNull(response);
  }
}
