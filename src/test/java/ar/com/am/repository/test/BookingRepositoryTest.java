package ar.com.am.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.am.clases.Reserva;
import ar.com.am.helper.ReservaHelper;
import ar.com.am.repositorios.BookingRepository;

@SpringBootTest
public class BookingRepositoryTest {
	
	@Autowired
	private BookingRepository repository;
	
	@Test
	public void testSaveRepositoryReservasSucces() {
		Reserva reserva = ReservaHelper.createReservaValida();
		this.repository.save(reserva);	
	}

}
