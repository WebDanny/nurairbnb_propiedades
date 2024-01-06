package use.cases.command.checkin.get.checkin;

import an.awesome.pipelinr.Command;
import dtos.CheckInDto;

public class GetCheckInQuery implements Command<CheckInDto> {

  public String flightId;
  public String passengerId;

  public GetCheckInQuery(String flightId, String passengerId) {
    this.flightId = flightId;
    this.passengerId = passengerId;
  }
}
