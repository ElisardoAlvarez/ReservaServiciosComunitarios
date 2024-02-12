import com.miempresa.reservaservicios.model.Reserva;
import com.miempresa.reservaservicios.repository.ReservaRepository;
import com.miempresa.reservaservicios.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalTime;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    private ReservaService reservaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        reservaService = new ReservaService(reservaRepository);
    }

    @Test
    public void testCrearReserva() {
        // Crear una reserva de prueba
        Reserva reserva = new Reserva();
        reserva.setHora(LocalTime.of(10, 0)); // 10:00 am

        // Configurar el mock del repositorio para devolver la reserva cuando se llame al método save
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        // Llamar al método crearReserva
        Reserva reservaCreada = reservaService.crearReserva(reserva);

        // Verificar que el método save del repositorio fue llamado
        verify(reservaRepository, times(1)).save(reserva);

        // Asegurarse de que la reserva creada tiene la misma hora que la reserva de prueba
        assertEquals(reserva.getHora(), reservaCreada.getHora());
    }
}