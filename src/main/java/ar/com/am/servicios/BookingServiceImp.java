package ar.com.am.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.am.clases.Reserva;
import ar.com.am.repositorios.BookingRepository;

@Service
public class BookingServiceImp implements BookingService {
	
	@Autowired
	private BookingRepository repositoryB;
	
	public void guardarReserva (Reserva r) {
		this.repositoryB.save(r);
	}

	@Override
	public Reserva obtenerReserva(Long id) {
		Optional<Reserva> user = this.repositoryB.findById(id);
		return user.get();
	}
}
