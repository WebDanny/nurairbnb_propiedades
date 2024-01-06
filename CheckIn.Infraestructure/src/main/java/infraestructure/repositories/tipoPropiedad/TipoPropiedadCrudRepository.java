package infraestructure.repositories.tipoPropiedad;

import infraestructure.model.TipoPropiedadJpaModel;
import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPropiedadCrudRepository extends CrudRepository<TipoPropiedadJpaModel, UUID> {

  List<TipoPropiedadJpaModel> findTipoPropiedadById(UUID id);
}
