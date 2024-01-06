package use.cases.command.persona.get.persona;

import an.awesome.pipelinr.Command;
import com.nur.model.Persona;
import com.nur.repositories.PersonaRepository;
import core.BusinessRuleValidationException;
import dtos.PersonaDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import utils.PersonaMapper;

@Component
public class GetPersonaHandler implements Command.Handler<GetPersonaQuery, List<PersonaDto>> {

  private final PersonaRepository passangerRepository;

  public GetPersonaHandler(PersonaRepository passangerRepository) {
    this.passangerRepository = passangerRepository;
  }

  @Override
  public List<PersonaDto> handle(GetPersonaQuery command) {
    try {
      List<Persona> passangers = this.passangerRepository.getAll();
      return passangers.stream().map(PersonaMapper::from).collect(Collectors.toList());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
