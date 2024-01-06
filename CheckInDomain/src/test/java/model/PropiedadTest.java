package model;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.model.Estado;
import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import value.objects.PrecioValue;

class PropiedadTest {
  private Propiedad propiedad;

  @BeforeEach
  public void setUp() {
    propiedad = new Propiedad();
  }

  @Test
  void testAgregarCaracteristica() throws Exception {
    UUID caracteristicaId = UUID.randomUUID();
    propiedad.agregarCaracteristica(
        caracteristicaId, true, false, false, false, false, false, false, false);

    assertEquals(1, propiedad.getCaracteristicasPropiedades().size());
  }

  @Test
  void testModificarPropiedad() throws BusinessRuleValidationException {
    UUID propiedadId = UUID.randomUUID();
    String nombre = "New Property";
    PrecioValue precio = new PrecioValue(1000.0);

    propiedad.modificarPropiedad(propiedadId, nombre, 100.0);

    // assertEquals(propiedadId, propiedad.getId());
    assertEquals(nombre, propiedad.getNombre());
    // assertEquals(precio, propiedad.getPrecio());
  }

  @Test
  void testEliminarPropiedad() {
    UUID propiedadId = UUID.randomUUID();

    propiedad.eliminarPropiedad(propiedadId);

    assertEquals(Estado.INHABILITADO, propiedad.getEstado());
  }

  @Test
  public void testAgregarTipoPropiedad() {
    UUID idTipo = UUID.randomUUID();
    String descripcion = "Some description";

    propiedad.agregarTipoPropiedad(idTipo, descripcion);
    assertNotNull(propiedad.getCaracteristicasPropiedades());
  }

  @Test
  public void testCrearPropiedad() {

    propiedad.crearPropiedad();
    assertNotNull(propiedad.getDomainEvents());
  }
}
