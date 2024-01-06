package use.cases.command.persona.get.persona;

import an.awesome.pipelinr.Command;
import dtos.PersonaDto;
import java.util.List;

public class GetPersonaQuery implements Command<List<PersonaDto>> {

  public GetPersonaQuery() {}
}
