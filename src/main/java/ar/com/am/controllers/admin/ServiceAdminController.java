package ar.com.am.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.am.clases.Servicio;
import ar.com.am.forms.ServicioForm;
import ar.com.am.servicios.ServiceService;

@Controller
public class ServiceAdminController {
	private static final String LIST_ATTRIBUTE = "listado";
	private static final String FORM_ATTRIBUTE = "form";
	private static final String PATH_PAGES_URL = "/admin/servicios";
	private static final String PATH_CONTEXT_URL = "/admin/service";
	@Autowired
	private ServiceService servicio;
	
	
	@GetMapping(value = PATH_CONTEXT_URL)
	public String init (Model model) {
		List<Servicio> servicios = this.servicio.listAll();
		model.addAttribute(LIST_ATTRIBUTE, servicios);
		return PATH_PAGES_URL + "/list";
	}

	
	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit (Model model) {
		model.addAttribute(FORM_ATTRIBUTE, new ServicioForm());
		return PATH_PAGES_URL + "/form";
	}
	
	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save (@ModelAttribute(name = FORM_ATTRIBUTE) ServicioForm formulario) {
		String nombre = formulario.getNombre();
		String descripcion = formulario.getDescripcion();
		int precio = formulario.getPrecio();
		String estado = formulario.getEstado();
		String duracion = formulario.getDuracion();
		
		Servicio servicio = new Servicio(nombre,precio);
		this.servicio.guardarServicio(servicio);
		return "redirect:" + PATH_CONTEXT_URL;
	}
}
