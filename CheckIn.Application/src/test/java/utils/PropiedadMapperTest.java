package utils;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import dtos.PropiedadDto;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadMapperTest {
  private PropiedadMapper propiedadMapper;

  @BeforeEach
  public void setUp() {
    propiedadMapper = new PropiedadMapper();
  }

  @Test
  public void testFromTransaccionNotNull() throws BusinessRuleValidationException {
    Propiedad propiedad = createSamplePropiedad();

    PropiedadDto propiedadDto = propiedadMapper.from(propiedad);

    assertNotNull(propiedadDto);
    assertEquals(propiedad.getId(), propiedadDto.id);
    assertEquals(propiedad.getNombre(), propiedadDto.nombre);
    assertEquals(propiedad.getEstado().toString(), propiedadDto.estado);
    assertEquals(propiedad.getPrecio(), propiedadDto.precio);
    assertNotNull(propiedad.getId());
    assertNotNull(propiedadDto.estado);
    assertNotNull(propiedadDto.id);
    assertNotNull(propiedadDto.precio);
    assertNotNull(propiedadDto.nombre);
  }

  @Test
  public void testFromTransccionNull() {
    Propiedad propiedad = null;
    PropiedadDto propiedadDto = PropiedadMapper.from(propiedad);
    assertNotNull(propiedadDto.precio);
    assertNull(propiedadDto.estado);
    assertNull(propiedadDto.nombre);
    assertNull(propiedadDto.id);
  }

  private Propiedad createSamplePropiedad() throws BusinessRuleValidationException {
    Propiedad propiedad = new Propiedad(UUID.randomUUID().toString(), "casa", "HABILITADA", 100.0);

    return propiedad;
  }

  /*@Test
  public void testMapToPropiedadDto_WithNullFields() throws BusinessRuleValidationException {
      Propiedad propiedad = new Propiedad(null, null, null, 0.0);

      PropiedadDto result = propiedadMapper.from(propiedad);

     assertEquals("", result.nombre);
      assertEquals("INHABILITADO", result.estado);
      assertEquals(0.0, result.precio);
  }*/
}
