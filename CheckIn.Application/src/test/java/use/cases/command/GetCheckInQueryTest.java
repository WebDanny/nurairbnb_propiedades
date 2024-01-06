package use.cases.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use.cases.command.checkin.get.checkin.GetCheckInQuery;

public class GetCheckInQueryTest {
  @Test
  public void testConstructor() {
    String flightId = "ABC123";
    String passengerId = "123456";

    GetCheckInQuery query = new GetCheckInQuery(flightId, passengerId);

    Assertions.assertEquals(flightId, query.flightId);
    Assertions.assertEquals(passengerId, query.passengerId);
  }
}
