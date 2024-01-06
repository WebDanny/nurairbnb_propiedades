package infraestructure.tipoPropiedad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nur.model.TipoPropiedad;
import core.BusinessRuleValidationException;
import infraestructure.model.TipoPropiedadJpaModel;
import infraestructure.repositories.tipoPropiedad.TipoPropiedadCrudRepository;
import infraestructure.repositories.tipoPropiedad.TipoPropiedadJpaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TipoPropiedadJpaRepositoryTest {

  private TipoPropiedadCrudRepository tipoPropiedadCrudRepository;
  private TipoPropiedadJpaRepository tipoPropiedadRepository;

  @BeforeEach
  public void setUp() {
    tipoPropiedadCrudRepository = mock(TipoPropiedadCrudRepository.class);
    tipoPropiedadRepository = new TipoPropiedadJpaRepository();
    tipoPropiedadRepository.setTipoPropiedadCrudRepository(tipoPropiedadCrudRepository);
  }

  @Test
  public void testFindTipoPropiedadById() throws BusinessRuleValidationException {

    UUID mockId = UUID.randomUUID();
    List<TipoPropiedadJpaModel> mockJpaModels = new ArrayList<>();

    when(tipoPropiedadCrudRepository.findTipoPropiedadById(mockId)).thenReturn(mockJpaModels);
    List<TipoPropiedad> result = tipoPropiedadRepository.findTipoPropiedadById(mockId);
    assertNotNull(result);
    assertEquals(mockJpaModels.size(), result.size());
  }

  @Test
  public void testGetAll() throws BusinessRuleValidationException {
    List<TipoPropiedadJpaModel> mockJpaModels = new ArrayList<>();

    when(tipoPropiedadCrudRepository.findAll()).thenReturn(mockJpaModels);

    List<TipoPropiedad> result = tipoPropiedadRepository.getAll();

    assertNotNull(result);
    assertEquals(mockJpaModels.size(), result.size());
  }

  @Test
  public void testUpdate() {
    TipoPropiedad mockTipoPropiedad = new TipoPropiedad(UUID.randomUUID(), "casa");

    TipoPropiedadJpaModel mockJpaModel = new TipoPropiedadJpaModel();
    mockJpaModel.setId(UUID.randomUUID());
    mockJpaModel.setNombreTipo("casa");
    when(tipoPropiedadCrudRepository.save(any(TipoPropiedadJpaModel.class)))
        .thenReturn(mockJpaModel);

    UUID result = tipoPropiedadRepository.update(mockTipoPropiedad);

    assertNotNull(result);
  }
}
