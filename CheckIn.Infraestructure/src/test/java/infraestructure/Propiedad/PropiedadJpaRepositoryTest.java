package infraestructure.Propiedad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nur.model.Propiedad;
import core.BusinessRuleValidationException;
import infraestructure.model.PropiedadJpaModel;
import infraestructure.repositories.propiedad.PropiedadCrudRepository;
import infraestructure.repositories.propiedad.PropiedadJpaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadJpaRepositoryTest {

  private PropiedadCrudRepository propiedadCrudRepository;
  private PropiedadJpaRepository propiedadRepository;

  @BeforeEach
  public void setUp() {
    propiedadCrudRepository = mock(PropiedadCrudRepository.class);
    propiedadRepository = new PropiedadJpaRepository();
    propiedadRepository.setPropiedadCrudRepository(propiedadCrudRepository);
  }

  @Test
  public void testFindByIdAndEstado() throws BusinessRuleValidationException {
    UUID mockId = UUID.randomUUID();
    String mockEstado = "HABILITADO";
    List<PropiedadJpaModel> mockJpaModels = new ArrayList<>();

    when(propiedadCrudRepository.findByIdAndEstado(mockId, mockEstado)).thenReturn(mockJpaModels);

    List<Propiedad> result = propiedadRepository.findByIdAndEstado(mockId, mockEstado);

    assertNotNull(result);
    assertEquals(mockJpaModels.size(), result.size());
  }

  @Test
  public void testFindPropiedadById() throws BusinessRuleValidationException {
    UUID mockId = UUID.randomUUID();
    List<PropiedadJpaModel> mockJpaModels = new ArrayList<>();
    when(propiedadCrudRepository.findPropiedadById(mockId)).thenReturn(mockJpaModels);
    List<Propiedad> result = propiedadRepository.findPropiedadById(mockId);

    assertNotNull(result);
    assertEquals(mockJpaModels.size(), result.size());
  }

  @Test
  public void testGetAll() throws BusinessRuleValidationException {
    // Arrange
    List<PropiedadJpaModel> mockJpaModels = new ArrayList<>();
    when(propiedadCrudRepository.findAll()).thenReturn(mockJpaModels);
    List<Propiedad> result = propiedadRepository.getAll();

    assertNotNull(result);
    assertEquals(mockJpaModels.size(), result.size());
  }
}
