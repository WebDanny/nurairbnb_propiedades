package use.cases.command.checkin.create.checkin;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;

public class CreateCheckInCommand implements Command<CheckInDto> {

  public CheckInDto checkInDto;

  public CreateCheckInCommand(CheckInDto checkInDto) {
    this.checkInDto = checkInDto;
  }
}
