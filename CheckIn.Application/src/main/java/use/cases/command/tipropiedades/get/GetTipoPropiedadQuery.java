package use.cases.command.tipropiedades.get;

import an.awesome.pipelinr.Command;
import dtos.TipoPropiedadDto;
import java.util.List;

public class GetTipoPropiedadQuery implements Command<List<TipoPropiedadDto>> {

  String id;

  public GetTipoPropiedadQuery(String id) {
    this.id = id;
  }
}
