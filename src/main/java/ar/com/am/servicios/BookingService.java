package ar.com.am.servicios;

import ar.com.am.clases.Reserva;

public interface BookingService {
	
	public Reserva obtenerReserva(Long id);

	public void guardarReserva(Reserva r);

}
