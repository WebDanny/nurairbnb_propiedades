package infraestructure.repositories.comodidad;

import com.nur.model.Comodidad;
import com.nur.repositories.ComodidadRepository;
import core.BusinessRuleValidationException;
import infraestructure.model.ComodidadJpaModel;
import infraestructure.utils.ComodidadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class ComodidadJpaRepository implements ComodidadRepository {

  @Autowired private ComodidadCrudRepository comodidadCrudRepository;

  /*@Override
  public UUID update(TipoPropiedad tipo) {
    TipoPropiedadJpaModel seatJpaModel = TipoPropiedadUtils.tipoToJpaEntity(tipo);
    return comodidadCrudRepository.save(seatJpaModel).getId();
  }

  @Override
  public List<TipoPropiedad> findTipoPropiedadById(UUID id) throws BusinessRuleValidationException {

    List<TipoPropiedadJpaModel> jpaModels = comodidadCrudRepository.findComodidaddById(id);
    if (jpaModels == null || jpaModels.size() == 0) return Collections.emptyList();
    List<TipoPropiedad> tipoPropiedads = new ArrayList<>();
    for (TipoPropiedadJpaModel jpaModel : jpaModels) {
      tipoPropiedads.add(TipoPropiedadUtils.jpaModelToTipoPropiedad(jpaModel));
    }
    return tipoPropiedads;
  }*/

  @Override
  public UUID update(Comodidad comodidad) {
    ComodidadJpaModel seatJpaModel = ComodidadUtils.tipoToJpaEntity(comodidad);
    return comodidadCrudRepository.save(seatJpaModel).getId();
  }

  @Override
  public List<Comodidad> findComodidadById(UUID id) throws BusinessRuleValidationException {
    return null;
  }

  @Override
  public List<Comodidad> getAll() throws BusinessRuleValidationException {
    List<ComodidadJpaModel> jpaModels = Streamable.of(comodidadCrudRepository.findAll()).toList();
    List<Comodidad> tipos = new ArrayList<>();
    for (ComodidadJpaModel jpaModel : jpaModels) {
      tipos.add(ComodidadUtils.jpaModelToTipoPropiedad(jpaModel));
    }
    return tipos;
  }

  public void setComodidadCrudRepository(ComodidadCrudRepository comodidadCrudRepository) {
    this.comodidadCrudRepository = comodidadCrudRepository;
  }
}
