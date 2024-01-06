package infraestructure.utils;

import com.nur.annotations.Generated;
import com.nur.model.Transaccion;
import core.BusinessRuleValidationException;
import infraestructure.model.TransactionJpaModel;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Generated
public class TransaccionUtils {

  public static TransactionJpaModel seatToJpaEntity(Transaccion seat) {
    if (seat == null) return null;
    TransactionJpaModel seatJpaModel = new TransactionJpaModel();
    seatJpaModel.setDescripcion(seat.getDescripcion());
    seatJpaModel.setCode(seat.getCode());
    seatJpaModel.setMonto(seat.getMonto());

    return seatJpaModel;
  }

  public static List<TransactionJpaModel> seatsToJpaEntities(List<Transaccion> seats) {
    if (seats == null) return Collections.emptyList();
    return seats.stream().map(TransaccionUtils::seatToJpaEntity).collect(Collectors.toList());
  }

  public static Transaccion jpaModelToSeat(TransactionJpaModel jpaModel)
      throws BusinessRuleValidationException {
    return new Transaccion(jpaModel.getCode(), jpaModel.getDescripcion(), jpaModel.getMonto());
  }
}
