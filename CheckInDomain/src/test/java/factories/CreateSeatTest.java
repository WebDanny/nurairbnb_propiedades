package factories;

import com.nur.factories.transaccion.CreateSeat;
import com.nur.model.Transaccion;
import core.BusinessRuleValidationException;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateSeatTest {
  private CreateSeat seatFactory;

  @BeforeEach
  public void setUp() {
    seatFactory = new CreateSeat();
  }

  @Test
  public void testCreateTransaccion() throws BusinessRuleValidationException {
    // Arrange
    String code = "f47ac10b-58cc-4372-a567-0e02b2c3d479";
    String descripcion = "Sample Transaction";
    double monto = 1000.0;

    Transaccion transaccion = seatFactory.create(code, descripcion, monto);

    Assertions.assertNotNull(transaccion);
    Assertions.assertEquals(UUID.fromString(code), transaccion.getCode());
    Assertions.assertEquals(descripcion, transaccion.getDescripcion());
    Assertions.assertEquals(
        monto, transaccion.getMonto(), 0.01); // Allow for small floating-point differences
  }
}
