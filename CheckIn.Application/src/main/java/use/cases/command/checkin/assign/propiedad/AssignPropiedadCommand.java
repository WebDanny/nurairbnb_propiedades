package use.cases.command.checkin.assign.propiedad;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;
import dtos.PropiedadDto;

public class AssignPropiedadCommand implements Command<PropiedadDto> {

  CheckInDto checkInDto;

  public AssignPropiedadCommand(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
