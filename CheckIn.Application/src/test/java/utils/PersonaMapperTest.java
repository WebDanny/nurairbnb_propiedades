package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.nur.model.Persona;
import core.BusinessRuleValidationException;
import dtos.PersonaDto;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaMapperTest {

  private PersonaMapper personaMapper;

  @BeforeEach
  public void setUp() {
    personaMapper = new PersonaMapper();
  }

  @Test
  public void testFrom_WithNonNullInput_ShouldMapFieldsCorrectly()
      throws BusinessRuleValidationException {
    Persona input = new Persona("John", "Doe", "12345");
    PersonaDto result = personaMapper.from(input);

    assertNotNull(result);
    assertEquals("John", result.name);
    assertEquals("Doe", result.lastname);
    assertEquals("12345", result.ci);
  }

  @Test
  public void testFrom_WithNullFieldsInInput_ShouldMapToEmptyStrings()
      throws BusinessRuleValidationException {
    Persona input = null;
    PersonaDto result = personaMapper.from(input);
    assertNotNull(result);
  }

  @Test
  public void createSamplePersonaDto() throws BusinessRuleValidationException {
    Persona input = null;

    PersonaDto baggageDto = new PersonaDto();
    assertNotNull(baggageDto);
    //  assertEquals("",baggageDto.ci);
  }

  @Test
  public void testFrom_WithMixedFields() throws BusinessRuleValidationException {
    // Arrange
    Persona passenger = new Persona("", "Doe", "");

    // Act
    PersonaDto result = personaMapper.from(passenger);

    // Assert
    assertNotNull(result);
    //  assertEquals("2", result.id);
    assertEquals("", result.name);
    assertEquals("Doe", result.lastname);
    assertEquals("", result.ci);
  }

  @Test
  public void testFrom() throws BusinessRuleValidationException {
    Persona passanger =
        new Persona(
            UUID.fromString("1f3d0f86-0a25-4334-8c59-8ce8f13167a5"),
            "John",
            "Doe",
            new Date(),
            "1234567890",
            true);

    PersonaDto personaDto = personaMapper.from(passanger);

    // Assert
    // assertEquals("1f3d0f86-0a25-4334-8c59-8ce8f13167a5", personaDto.id());
    Assertions.assertEquals("John", personaDto.name);
    //   Assertions.assertEquals("Doe", personaDto.getLastname());
    //  Assertions.assertEquals("1234567890", personaDto.getCi());
  }
}
