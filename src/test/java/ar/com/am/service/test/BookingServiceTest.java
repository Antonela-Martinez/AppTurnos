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
import ar.com.am.servicios.ServiceService;
import ar.com.am.servicios.UserService;

@SpringBootTest
@ActiveProfiles("test")
public class BookingServiceTest {
	
	@Autowired
	private BookingService servicio;
	@Autowired
	private UserService userService;
	@Autowired
	private ServiceService servicioService;
	
	
	@Test
	public void testSaveReservaSucces() {
		Profesional profesional = (Profesional) userService.obtenerUsuario(4L);
		Servicio servicio = servicioService.obtenerServicio(1L);
		
		Cliente cliente = this.userService.getByDni(1L);
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
