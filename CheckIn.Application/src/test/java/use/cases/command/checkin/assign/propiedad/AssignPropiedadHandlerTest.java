package use.cases.command.checkin.assign.propiedad;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nur.model.CheckIn;
import com.nur.model.Persona;
import com.nur.model.Propiedad;
import com.nur.repositories.CheckInRepository;
import com.nur.repositories.PropiedadRepository;
import dtos.CheckInDto;
import dtos.PersonaDto;
import dtos.PropiedadDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssignPropiedadHandlerTest {

  private CheckInRepository checkInRepository;
  private PropiedadRepository propiedadRepository;
  private AssignPropiedadHandler assignPropiedadHandler;

  @BeforeEach
  public void setUp() {
    checkInRepository = mock(CheckInRepository.class);
    propiedadRepository = mock(PropiedadRepository.class);
    assignPropiedadHandler = new AssignPropiedadHandler(checkInRepository, propiedadRepository);
  }

  @Test
  public void testHandle() throws Exception {
    List<PropiedadDto> listDto = new ArrayList<>();
    PropiedadDto propiedadDTo = new PropiedadDto(UUID.randomUUID(), "Casa", "HABILITADA", 100.0);

    CheckInDto dto =
        new CheckInDto(
            "123",
            propiedadDTo.id.toString(),
            new Date(),
            propiedadDTo,
            listDto,
            new PersonaDto(UUID.randomUUID().toString(), "test", "test", "123"));

    AssignPropiedadCommand command = new AssignPropiedadCommand(dto);
    List<Propiedad> list = new ArrayList<>();
    list.add(new Propiedad(String.valueOf(UUID.randomUUID()), "Casa", "HABILITADA", 100.0));
    CheckIn mockCheckIn =
        new CheckIn(
            UUID.randomUUID(),
            UUID.randomUUID(),
            new Date(),
            new Propiedad(),
            list,
            new Persona("test", "test", "123"));
    when(checkInRepository.findByPersonAndId(any(UUID.class), any(UUID.class)))
        .thenReturn(mockCheckIn);
    when(checkInRepository.update(any(CheckIn.class))).thenReturn(UUID.randomUUID());

    PropiedadDto result = assignPropiedadHandler.handle(command);

    assertNotNull(result);
  }
}
