package ar.com.am.helper;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Reserva;
import ar.com.am.clases.Servicio;
import ar.com.am.servicios.ServiceService;
import ar.com.am.servicios.UserService;

public class ReservaHelper {
	public static final Profesional profesional = UsuarioHelper.createProfesionalValido();
	public static final Cliente cliente = UsuarioHelper.createValidClient();
	public static final Servicio servicio = ServicioHelper.createServicioValido();
	public static final LocalDate fecha = LocalDate.now();
	public static final int hora = 17;
	
	@Autowired
	private UserService userService;
	@Autowired
	private ServiceService service;
	
	public final static Reserva createReservaValida() {
		

		
		return new Reserva(ReservaHelper.cliente,profesional,ReservaHelper.servicio,ReservaHelper.fecha,ReservaHelper.hora );
	}


}
