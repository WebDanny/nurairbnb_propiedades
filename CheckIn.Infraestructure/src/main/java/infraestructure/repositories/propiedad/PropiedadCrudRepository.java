package infraestructure.repositories.propiedad;

import infraestructure.model.PropiedadJpaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropiedadCrudRepository extends CrudRepository<PropiedadJpaModel, UUID> {
  List<PropiedadJpaModel> findByIdAndEstado(UUID id, String estado);

  List<PropiedadJpaModel> findPropiedadById(UUID id);
}
