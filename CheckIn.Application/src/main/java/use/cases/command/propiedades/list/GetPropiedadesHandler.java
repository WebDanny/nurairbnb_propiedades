package use.cases.command.propiedades.list;

import an.awesome.pipelinr.Command;
import com.nur.model.Propiedad;
import com.nur.repositories.PropiedadRepository;
import core.BusinessRuleValidationException;
import dtos.PropiedadDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import utils.PropiedadMapper;

@Component
public class GetPropiedadesHandler
    implements Command.Handler<GetPropiedadesQuery, List<PropiedadDto>> {

  private final PropiedadRepository propiedadRepository;

  public GetPropiedadesHandler(PropiedadRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<PropiedadDto> handle(GetPropiedadesQuery command) {
    try {
      List<Propiedad> propiedad = this.propiedadRepository.getAll();
      return propiedad.stream().map(PropiedadMapper::from).collect(Collectors.toList());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
