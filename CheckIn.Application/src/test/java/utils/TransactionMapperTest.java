package utils;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.model.Transaccion;
import core.BusinessRuleValidationException;
import dtos.TransactionDto;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionMapperTest {
  private TransaccionMapper tMapper;

  @BeforeEach
  public void setUp() {
    tMapper = new TransaccionMapper();
  }

  @Test
  public void testFromTransactionNotNull() throws BusinessRuleValidationException {
    Transaccion transaction = createSampleTransactoion();

    TransactionDto tDto = tMapper.from(transaction);

    assertNotNull(tDto);
    assertEquals(transaction.getCode().toString(), tDto.code);
    assertEquals(transaction.getDescripcion().toString(), tDto.descripcion);
    assertEquals(transaction.getMonto(), tDto.monto);
    assertNotNull(transaction.getId());
  }

  @Test
  public void testFromTransactionNull() {
    Transaccion transaccion = null;
    TransactionDto transactionDto = TransaccionMapper.from(transaccion);
    assertNotNull(transactionDto);
    assertNull(transactionDto.code);
    assertNull(transactionDto.descripcion);
  }

  private Transaccion createSampleTransactoion() throws BusinessRuleValidationException {
    Transaccion transaccion =
        new Transaccion(UUID.fromString("07e8083f-c652-48ca-b883-4d64db0fab3e"), "renta", 100.0);

    return transaccion;
  }

  @Test
  public void testFrom_WithMixedFields() {
    // Arrange
    Transaccion passenger = new Transaccion(UUID.randomUUID(), null, null);

    // Act
    TransactionDto result = tMapper.from(passenger);

    // Assert
    assertNotNull(result);
    assertEquals(0.0, result.monto);
    assertEquals("", result.descripcion);
    // assertEquals("", result.code);

  }
}
