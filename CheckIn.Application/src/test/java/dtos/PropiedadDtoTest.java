package dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import org.junit.jupiter.api.Test;

public class PropiedadDtoTest {

  @Test
  public void testConstructorAndGetters() {
    UUID id = UUID.randomUUID();
    String nombre = "Sample Property";
    String estado = "Available";
    double precio = 100000.0;

    PropiedadDto propiedad = new PropiedadDto(id, nombre, estado, precio);

    assertEquals(id, propiedad.id);
    assertEquals(nombre, propiedad.nombre);
    assertEquals(estado, propiedad.estado);
    assertEquals(precio, propiedad.precio, 0.01);
  }

  @Test
  public void testDefaultConstructor() {
    PropiedadDto propiedad = new PropiedadDto();

    assertEquals(null, propiedad.id);
    assertEquals(null, propiedad.nombre);
    assertEquals(null, propiedad.estado);
    assertEquals(0.0, propiedad.precio, 0.01);
  }
}
