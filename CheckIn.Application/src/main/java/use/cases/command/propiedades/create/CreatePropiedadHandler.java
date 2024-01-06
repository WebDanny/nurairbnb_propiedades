package use.cases.command.propiedades.create;

import an.awesome.pipelinr.Command;
import com.nur.factories.propiedad.PropiedadFactory;
import com.nur.model.Propiedad;
import com.nur.repositories.PropiedadRepository;
import core.BusinessRuleValidationException;
import dtos.PropiedadDto;
import org.springframework.stereotype.Component;
import utils.PropiedadMapper;

@Component
public class CreatePropiedadHandler
    implements Command.Handler<CreatePropiedadCommand, PropiedadDto> {

  private final PropiedadRepository propiedadRepository;

  private final PropiedadFactory propiedadFactory;

  public CreatePropiedadHandler(PropiedadRepository propiedadRepository) {

    this.propiedadRepository = propiedadRepository;

    this.propiedadFactory = new PropiedadFactory();
  }

  @Override
  public PropiedadDto handle(CreatePropiedadCommand request) {
    try {
      Propiedad propiedad =
          propiedadFactory.create(
              String.valueOf(request.propiedadDto.id),
              request.propiedadDto.nombre,
              request.propiedadDto.estado,
              request.propiedadDto.precio);
      propiedadRepository.update(propiedad);
      return PropiedadMapper.from(propiedad);
    } catch (BusinessRuleValidationException e) {
      return null;
    }
  }
}
