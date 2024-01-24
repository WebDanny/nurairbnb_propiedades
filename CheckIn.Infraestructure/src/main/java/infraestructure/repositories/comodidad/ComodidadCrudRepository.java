package infraestructure.repositories.comodidad;

import infraestructure.model.ComodidadJpaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComodidadCrudRepository extends CrudRepository<ComodidadJpaModel, UUID> {

  List<ComodidadJpaModel> findComodidaddById(UUID id);
}
