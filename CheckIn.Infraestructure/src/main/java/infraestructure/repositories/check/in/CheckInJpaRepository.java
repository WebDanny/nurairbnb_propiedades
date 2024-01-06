package infraestructure.repositories.check.in;

import com.nur.model.CheckIn;
import com.nur.repositories.CheckInRepository;
import core.BusinessRuleValidationException;
import infraestructure.model.CheckInJpaModel;
import infraestructure.model.PersonaJpaModel;
import infraestructure.model.PropiedadJpaModel;
import infraestructure.repositories.persona.PersonaCrudRepository;
import infraestructure.repositories.propiedad.PropiedadCrudRepository;
import infraestructure.utils.CheckInUtils;
import infraestructure.utils.PersonaUtils;
import infraestructure.utils.PropiedadUtils;
import jakarta.transaction.Transactional;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CheckInJpaRepository implements CheckInRepository {

  @Autowired private CheckInCrudRepository checkInCrudRepository;

  @Autowired private PersonaCrudRepository passangerCrudRepository;

  @Autowired private PropiedadCrudRepository seatCrudRepository;

  @Override
  @Transactional
  public UUID update(CheckIn checkIn) {
    CheckInJpaModel checkInJpaModel = new CheckInJpaModel();
    checkInJpaModel.setPropiedadId(checkIn.getPropiedadId());
    checkInJpaModel.setDate(checkIn.getDate());
    checkInJpaModel.setId(checkIn.getId());
    checkInJpaModel.setPersona(PersonaUtils.passangerToJpaEntity(checkIn.getPersona()));

    if (checkIn.getPropiedad() != null) {
      checkInJpaModel.setPropiedad(PropiedadUtils.propiedadToJpaEntity(checkIn.getPropiedad()));
    }
    return checkInCrudRepository.save(checkInJpaModel).getId();
  }

  @Override
  public CheckIn get(UUID id) {
    try {
      return CheckInUtils.jpaModelToCheckIn(
          checkInCrudRepository.findById(id).orElse(null), new ArrayList<>());
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public CheckIn findByPersonAndId(UUID passengerId, UUID flightId)
      throws BusinessRuleValidationException {
    PersonaJpaModel passangerJpaModel = passangerCrudRepository.findById(passengerId).orElse(null);
    if (passangerJpaModel == null) return null;
    CheckInJpaModel model =
        checkInCrudRepository.findByPersonaAndPersonaId(passangerJpaModel, flightId);
    if (model != null) {
      List<PropiedadJpaModel> seatsAvailable = seatCrudRepository.findPropiedadById(flightId);
      return CheckInUtils.jpaModelToCheckIn(model, seatsAvailable);
    }
    return null;
  }
}
