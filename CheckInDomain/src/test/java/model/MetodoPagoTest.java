package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nur.model.MetodoPago;
import com.nur.model.MetodoTipo;
import core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

class MetodoPagoTest {
  @Test
  void testConstructorWithValidTipo() throws BusinessRuleValidationException {
    MetodoPago metodoPago = new MetodoPago("Detalle", "T");

    assertEquals("Detalle", metodoPago.getDetalle());
    assertEquals(MetodoTipo.TARJETA, metodoPago.getType());
  }

  @Test
  void testGetDetalle() throws BusinessRuleValidationException {
    MetodoPago metodoPago = new MetodoPago("Detalle", "T");

    assertEquals("Detalle", metodoPago.getDetalle());
  }

  @Test
  void testGetType() throws BusinessRuleValidationException {
    MetodoPago metodoPago = new MetodoPago("Detalle", "T");

    assertEquals(MetodoTipo.TARJETA, metodoPago.getType());
  }
}
