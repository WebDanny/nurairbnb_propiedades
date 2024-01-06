package use.cases.command.propiedades.get;

import an.awesome.pipelinr.Command;
import com.nur.model.Propiedad;
import com.nur.repositories.PropiedadRepository;
import core.BusinessRuleValidationException;
import dtos.PropiedadDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import utils.PropiedadMapper;

@Component
public class GetPropiedadHandler implements Command.Handler<GetPropiedadQuery, List<PropiedadDto>> {

  private final PropiedadRepository propiedadRepository;

  public GetPropiedadHandler(PropiedadRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<PropiedadDto> handle(GetPropiedadQuery command) {
    try {
      List<Propiedad> propiedades =
          propiedadRepository.findPropiedadById(UUID.fromString(command.id));
      return propiedades.stream().map(PropiedadMapper::from).collect(Collectors.toList());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
