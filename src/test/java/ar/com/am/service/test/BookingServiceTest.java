package ar.com.am.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import ar.com.am.servicios.BookingService;

@SpringBootTest
public class BookingServiceTest {
	
	@Autowired
	private BookingService servicio;
	
	/*@Test
	public void testSaveReservaSucces() {
		
		
		Reserva reserva = ReservaHelper.createReservaValida();
		
		this.servicio.guardarReserva(reserva);
		
	}*/
	
	

}
