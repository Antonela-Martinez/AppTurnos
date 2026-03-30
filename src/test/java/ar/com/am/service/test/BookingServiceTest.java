package ar.com.am.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Reserva;
import ar.com.am.clases.Servicio;
import ar.com.am.helper.ReservaHelper;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.servicios.BookingService;
import ar.com.am.servicios.ClienteService;
import ar.com.am.servicios.ProfesionalService;
import ar.com.am.servicios.ServiceService;

@SpringBootTest
@ActiveProfiles("test")
public class BookingServiceTest {
	
	@Autowired
	private BookingService servicio;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProfesionalService profesionalService;
	@Autowired
	private ServiceService servicioService;
	
	
	@Test
	public void testSaveReservaSucces() {
		Profesional profesional = profesionalService.obtenerUsuario(4L);
		Servicio servicio = servicioService.obtenerServicio(1L);
		
		Cliente cliente = this.clienteService.getByDni(1L);
			if(cliente==null) {
				cliente = UsuarioHelper.createValidClient();
			}
		
		Reserva reserva = ReservaHelper.createReservaValida(profesional,servicio,cliente);
		this.servicio.guardarReserva(reserva);	
	}
	
	@Test
	public void testListAllReservas() {
		this.servicio.listAll();
	}

}
