package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nur.model.CaracteristicasPropiedad;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CaracteristicasPropiedadTest {
  @Test
  void testGetId() {
    UUID id = UUID.randomUUID();
    CaracteristicasPropiedad caracteristicas =
        new CaracteristicasPropiedad(id, true, false, true, false, true, false, true, false);

    UUID result = caracteristicas.getId();
    assertEquals(id, result);
  }
}
