package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.Reserva;
import ar.com.am.helper.ReservaHelper;
import ar.com.am.helper.UsuarioHelper;

public class ReservaEntityTest {
	
	@Test
	public void testReservaValida() {
			Reserva r = ReservaHelper.createReservaValida();
			r.setCliente(UsuarioHelper.createValidClient());
			Reserva reserva = ReservaHelper.createReservaValida();
			assertEquals(r.getCliente(), reserva.getCliente());
	}
	
	@Test
	public void  testReservaClienteNull() {
		try {
			Reserva r = ReservaHelper.createReservaValida();
			r.setCliente(null);
		}catch(IllegalArgumentException e) {
			assertEquals(Reserva.ERROR_MESSAGE_EMPTY_CLIENTE,e.getMessage());
		}
	}
	
	@Test
	public void  testReservaProfesionalNull() {
		try {
			Reserva r = ReservaHelper.createReservaValida();
			r.setProfesional(null);
		}catch(IllegalArgumentException e) {
			assertEquals(Reserva.ERROR_MESSAGE_EMPTY_PROF,e.getMessage());
		}
	}
	
	@Test
	public void  testReservaServicioNull() {
		try {
			Reserva r = ReservaHelper.createReservaValida();
			r.setServicio(null);
		}catch(IllegalArgumentException e) {
			assertEquals(Reserva.ERROR_MESSAGE_EMPTY_SERVICIO,e.getMessage());
		}
	}
	
	@Test
	public void  testReservaFechaNull() {
		try {
			Reserva r = ReservaHelper.createReservaValida();
			r.setFecha(null);
		}catch(IllegalArgumentException e) {
			assertEquals(Reserva.ERROR_MESSAGE_EMPTY_FECHA,e.getMessage());
		}
	}
	
	@Test
	public void  testReservaHoraVacia() {
		try {
			Reserva r = ReservaHelper.createReservaValida();
			r.setHora(0);
		}catch(IllegalArgumentException e) {
			assertEquals(Reserva.ERROR_HORA_INVALIDA,e.getMessage());
		}
	}
	
	
    
}
