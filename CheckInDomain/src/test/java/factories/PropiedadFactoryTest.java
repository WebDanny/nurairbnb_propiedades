package factories;

import com.nur.factories.propiedad.PropiedadFactory;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadFactoryTest {
  private PropiedadFactory checkInFactory;

  @BeforeEach
  void setUp() {
    checkInFactory = new PropiedadFactory();
  }

  @Test
  void testCreateCheckIn() throws BusinessRuleValidationException {

    UUID id = UUID.randomUUID();
    String nombre = "Sample Property";
    String estado = "Available";
    double precio = 1000.0;

    Propiedad propiedad = checkInFactory.create(String.valueOf(id), nombre, estado, precio);

    Assertions.assertNotNull(propiedad);
    Assertions.assertEquals(id, propiedad.getId());
    Assertions.assertEquals(nombre, propiedad.getNombre());
  }
}
