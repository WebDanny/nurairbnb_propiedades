package infraestructure.repositories.persona;

import com.nur.model.Persona;
import com.nur.repositories.PersonaRepository;
import core.BusinessRuleValidationException;
import infraestructure.model.PersonaJpaModel;
import infraestructure.utils.PersonaUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaJpaRepository implements PersonaRepository {

  @Autowired private PersonaCrudRepository passangerCrudRepository;

  @Override
  public UUID update(Persona passanger) {
    PersonaJpaModel jpaModel = PersonaUtils.passangerToJpaEntity(passanger);
    return passangerCrudRepository.save(jpaModel).getId();
  }

  @Override
  public Persona get(UUID id) throws BusinessRuleValidationException {
    PersonaJpaModel jpaModel = passangerCrudRepository.findById(id).orElse(null);
    if (jpaModel == null) return null;
    return PersonaUtils.jpaModelToPassanger(jpaModel);
  }

  @Override
  public List<Persona> getAll() throws BusinessRuleValidationException {
    List<PersonaJpaModel> jpaModels = Streamable.of(passangerCrudRepository.findAll()).toList();
    List<Persona> passengers = new ArrayList<>();
    for (PersonaJpaModel jpaModel : jpaModels) {
      passengers.add(PersonaUtils.jpaModelToPassanger(jpaModel));
    }
    return passengers;
  }
}
