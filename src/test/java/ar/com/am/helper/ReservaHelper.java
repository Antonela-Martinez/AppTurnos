package ar.com.am.helper;

import java.time.LocalDate;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Reserva;
import ar.com.am.clases.Servicio;

public class ReservaHelper {
	public static final Profesional profesional = UsuarioHelper.createProfesionalValido();
	public static final Cliente cliente = UsuarioHelper.createValidClient();
	public static final Servicio servicio = ServicioHelper.createServicioValido();
	public static final LocalDate fecha = LocalDate.now();
	public static final int hora = 17;
	
	public final static Reserva createReservaValida() {
		return new Reserva(ReservaHelper.cliente,ReservaHelper.profesional,ReservaHelper.servicio,ReservaHelper.fecha,ReservaHelper.hora );
	}


}
