package ar.com.am.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.am.clases.Reserva;
import ar.com.am.repositorios.BookingRepository;

public class BookingServiceImp implements BookingService {
	
	@Autowired
	private BookingRepository repositoryB;
	
	public void guardarReserva (Reserva r) {
		this.repositoryB.save(r);
	}
}
