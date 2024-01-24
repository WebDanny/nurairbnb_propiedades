package use.cases.command;

import com.nur.repositories.CheckInRepository;
import com.nur.repositories.PersonaRepository;
import com.nur.repositories.PropiedadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use.cases.command.checkin.create.checkin.CreateCheckInHandler;

public class CreateCheckInHandlerTest {

  private CreateCheckInHandler createCheckInHandler;

  @Mock private CheckInRepository checkInRepository;

  @Mock private PropiedadRepository propiedadRepository;

  @Mock private PersonaRepository personaRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    createCheckInHandler =
        new CreateCheckInHandler(checkInRepository, propiedadRepository, personaRepository);
  }
}

 /* @Test
 public void testHandle_WhenCheckInExists_ShouldReturnExistingCheckInDto()
     throws BusinessRuleValidationException {
   CreateCheckInCommand request = createSampleCreateCheckInCommand();
   CheckIn existingCheckIn = createSampleCheckIn();

   when(checkInRepository.findByPersonAndId(any(UUID.class), any(UUID.class)))
       .thenReturn(existingCheckIn);

   // Act
   //   CheckInDto result = createCheckInHandler.handle(request);

   // Assert
   // assertNotNull(result);
   // assertEquals(existingCheckIn.getId(), UUID.fromString(result.checkInId));
   // Add more assertions as needed.
 }

 @Test
 public void testHandle_WhenCheckInDoesNotExist_ShouldCreateNewCheckInAndReturnDto()
     throws BusinessRuleValidationException {
   // Arrange
   CreateCheckInCommand request = createSampleCreateCheckInCommand();
   CheckIn newCheckIn = createSampleCheckIn();

   when(checkInRepository.findByPersonAndId(any(UUID.class), any(UUID.class))).thenReturn(null);
   when(personaRepository.get(any(UUID.class))).thenReturn(createSamplePersona());
   when(propiedadRepository.findPropiedadById(any(UUID.class)))
       .thenReturn(createSamplePropiedadList());
   /*  when(checkInRepository.update(any(CheckIn.class)))
   .thenReturn(newCheckIn);*/

    // Act
    //  CheckInDto result = createCheckInHandler.handle(request);

    // Assert
    // assertNotNull(result);
    /// assertEquals(newCheckIn.getId(), UUID.fromString(result.checkInId));
    // Add more assertions as needed.
  /*}

   private CreateCheckInCommand createSampleCreateCheckInCommand() {
     return new CreateCheckInCommand(new CheckInDto());
   }

  /* private CheckIn createSampleCheckIn() throws BusinessRuleValidationException {
     return new CheckIn(
         UUID.randomUUID(),
         Arrays.asList(new Propiedad(UUID.randomUUID().toString(), "casa", "HABILITADA", 100.0)),
         new Persona("juan", "perez", "123"));
   }*/

  /*private Persona createSamplePersona() throws BusinessRuleValidationException {
      return new Persona("", "Doe", "");
    }

    private List<Propiedad> createSamplePropiedadList() throws BusinessRuleValidationException {
      return new ArrayList<>(); // new ArrayList<>().add(new Propiedad(UUID.randomUUID(),"casa",
      // "HABILITADA", 100.0));
    }
  }*/
