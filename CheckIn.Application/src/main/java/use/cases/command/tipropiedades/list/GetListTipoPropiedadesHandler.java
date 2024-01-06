package use.cases.command.tipropiedades.list;

import an.awesome.pipelinr.Command;
import com.nur.model.TipoPropiedad;
import com.nur.repositories.TipoPropiedadRepository;
import core.BusinessRuleValidationException;
import dtos.TipoPropiedadDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import utils.TipoPropiedadMapper;

@Component
public class GetListTipoPropiedadesHandler
    implements Command.Handler<GetListTipoPropiedadesQuery, List<TipoPropiedadDto>> {

  private final TipoPropiedadRepository tipo;

  public GetListTipoPropiedadesHandler(TipoPropiedadRepository tipo) {
    this.tipo = tipo;
  }

  @Override
  public List<TipoPropiedadDto> handle(GetListTipoPropiedadesQuery command) {
    try {
      List<TipoPropiedad> tipo = this.tipo.getAll();
      return tipo.stream().map(TipoPropiedadMapper::from).collect(Collectors.toList());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
