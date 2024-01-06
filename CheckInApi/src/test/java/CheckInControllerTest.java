import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.danny.checkinapi.controllers.CheckInController;
import dtos.CheckInDto;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CheckInControllerTest {

  @Mock Pipeline pipeline;

  private static final UUID CHECK_ID = UUID.randomUUID();

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetCheckInById() {
    CheckInDto tipoDtos = new CheckInDto();
    when(pipeline.send((Command<Object>) anyObject())).thenReturn(tipoDtos);

    CheckInController controller = new CheckInController(pipeline);
    CheckInDto response = controller.getCheckIn(CHECK_ID.toString(), "123");
    assertNotNull(response);
  }
}
