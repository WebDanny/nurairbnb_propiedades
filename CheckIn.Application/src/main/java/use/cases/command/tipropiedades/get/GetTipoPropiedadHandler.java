package use.cases.command.tipropiedades.get;

import an.awesome.pipelinr.Command;
import com.nur.model.TipoPropiedad;
import com.nur.repositories.TipoPropiedadRepository;
import core.BusinessRuleValidationException;
import dtos.TipoPropiedadDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import utils.TipoPropiedadMapper;

@Component
public class GetTipoPropiedadHandler
    implements Command.Handler<GetTipoPropiedadQuery, List<TipoPropiedadDto>> {

  private final TipoPropiedadRepository propiedadRepository;

  public GetTipoPropiedadHandler(TipoPropiedadRepository propiedadRepository) {
    this.propiedadRepository = propiedadRepository;
  }

  @Override
  public List<TipoPropiedadDto> handle(GetTipoPropiedadQuery command) {
    try {
      List<TipoPropiedad> propiedades =
          propiedadRepository.findTipoPropiedadById(UUID.fromString(command.id));
      return propiedades.stream().map(TipoPropiedadMapper::from).collect(Collectors.toList());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
