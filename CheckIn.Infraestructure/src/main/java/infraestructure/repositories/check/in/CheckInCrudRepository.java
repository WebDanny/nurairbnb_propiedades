package infraestructure.repositories.check.in;

import infraestructure.model.CheckInJpaModel;
import infraestructure.model.PersonaJpaModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckInCrudRepository extends CrudRepository<CheckInJpaModel, UUID> {
  CheckInJpaModel findByPersonaAndPersonaId(PersonaJpaModel passanger, UUID flightId);
}
