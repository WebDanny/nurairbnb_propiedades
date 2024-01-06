package use.cases.command.tipropiedades.create;

import an.awesome.pipelinr.Command;
import dtos.TipoPropiedadDto;

public class CreateTipoCommand implements Command<TipoPropiedadDto> {

  TipoPropiedadDto checkInDto;

  public CreateTipoCommand(TipoPropiedadDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
