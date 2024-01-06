package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nur.model.TransaccionPago;
import core.BusinessRuleValidationException;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class TransaccionTest {
  @Test
  void testConstructor() throws BusinessRuleValidationException {
    TransaccionPago transaccionPago = new TransaccionPago("John", "Doe", "123456789");

    assertEquals("John", transaccionPago.getName());
    assertEquals("Doe", transaccionPago.getLastname());
    assertEquals("123456789", transaccionPago.getCi());
  }

  @Test
  void testConstructorWithId() throws BusinessRuleValidationException {
    TransaccionPago transaccionPago =
        new TransaccionPago(UUID.randomUUID(), "Jane", "Smith", new Date(), "987654321", true);

    assertEquals("Jane", transaccionPago.getName());
    assertEquals("Smith", transaccionPago.getLastname());
    assertEquals("987654321", transaccionPago.getCi());
  }
}
