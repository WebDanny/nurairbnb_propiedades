package use.cases.command.checkin.transacction;

import an.awesome.pipelinr.Command;
import com.nur.model.Transaccion;
import com.nur.repositories.TransactionRepository;
import core.BusinessRuleValidationException;
import dtos.TransactionDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import utils.TransaccionMapper;

@Component
public class GetTransactionHandler
    implements Command.Handler<GetTransactionQuery, List<TransactionDto>> {

  private final TransactionRepository seatRepository;

  public GetTransactionHandler(TransactionRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  @Override
  public List<TransactionDto> handle(GetTransactionQuery command) {
    try {
      List<Transaccion> seats =
          seatRepository.findByTransactionCode(UUID.fromString(command.flightId));
      return seats.stream().map(TransaccionMapper::from).collect(Collectors.toList());
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
