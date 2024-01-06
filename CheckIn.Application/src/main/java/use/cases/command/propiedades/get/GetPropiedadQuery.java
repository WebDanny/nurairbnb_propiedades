package use.cases.command.propiedades.get;

import an.awesome.pipelinr.Command;
import dtos.PropiedadDto;
import java.util.List;

public class GetPropiedadQuery implements Command<List<PropiedadDto>> {

  String id;

  public GetPropiedadQuery(String id) {
    this.id = id;
  }
}
