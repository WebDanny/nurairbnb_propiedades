package use.cases.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use.cases.command.checkin.transacction.GetTransactionQuery;

public class GetTransactionQueryTest {
  @Test
  public void testConstructor() {

    String flightId = "ABC123";

    GetTransactionQuery query = new GetTransactionQuery(flightId);

    Assertions.assertEquals(flightId, query.flightId);
  }
}
