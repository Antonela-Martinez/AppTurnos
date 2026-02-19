package ar.com.am.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Reserva;
import ar.com.am.clases.Servicio;
import ar.com.am.forms.ReservaForm;
import ar.com.am.servicios.BookingService;
import ar.com.am.servicios.ServiceService;
import ar.com.am.servicios.UserService;


@Controller
public class ReservaController {
	private static final String PATH_PAGES_URL = "/reservas";
	private static final String PATH_CONTEXT_URL = "/reserva";
	private static final String FORM_ATTRIBUTE = "form";
	@Autowired
	private BookingService servicio;
	@Autowired
	private ServiceService servicioService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value = PATH_CONTEXT_URL + "/create")
	public String create (Model model) {//para acceder al modelo de la capa de vista
		model.addAttribute(FORM_ATTRIBUTE, new ReservaForm());
		//model.addAttribute("servicios", servicioService.listAll());
		//model.addAttribute("profesional", userService.listAll());
		return PATH_PAGES_URL + "/form";
	}
	
	
	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save(@ModelAttribute(name = FORM_ATTRIBUTE) ReservaForm formulario) {
		
		Long dni = formulario.getDni();
		String nombre = formulario.getNombre();
		String apellido = formulario.getApellido();
		long telefono = formulario.getTelefono();
		String email = formulario.getEmail();
		
		Servicio servicio = servicioService.obtenerServicio(1L);
		Profesional profesional = (Profesional) userService.obtenerUsuario(4L);
		
		//Servicio servicio = servicioService.obtenerServicio(formulario.getServicioId());
		//Profesional profesional = (Profesional) userService.obtenerUsuario(formulario.getProfesionalId());
		
		LocalDate fecha = formulario.getFecha();
		int hora = 14; // formulario.getHora();
		
		Cliente cliente = new Cliente(dni,nombre,apellido,telefono,email);
		Reserva reserva = new Reserva(cliente,profesional,servicio,fecha,hora);
		
		this.servicio.guardarReserva(reserva);
		return PATH_PAGES_URL + "/succes";
	}
	
}
