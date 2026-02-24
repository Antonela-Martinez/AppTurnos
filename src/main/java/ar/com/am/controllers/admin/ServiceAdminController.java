package ar.com.am.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.am.clases.Servicio;
import ar.com.am.dtos.ServicioDTO;
import ar.com.am.forms.ServicioForm;
import ar.com.am.servicios.ServiceService;

@Controller
public class ServiceAdminController {
	private static final String LIST_ATTRIBUTE = "listado";
	private static final String FORM_ATTRIBUTE = "form";
	private static final String PATH_PAGES_URL = "/admin/servicios";
	private static final String PATH_CONTEXT_URL = "c";
	@Autowired
	private ServiceService servicio;
	
	
	@GetMapping(value = PATH_CONTEXT_URL)
	public String init (Model model) {
		List<ServicioDTO> servicios = this.servicio.listAll();
		model.addAttribute(LIST_ATTRIBUTE, servicios);
		return PATH_PAGES_URL + "/list";
	}

	
	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit (Model model, @RequestParam(name = "id" , defaultValue = "-1") Long id) {
		ServicioForm formulario = new ServicioForm();
		
			if(id != null &&  id > 0) {
				Servicio servicio = this.servicio.obtenerServicio(id);
				
				formulario.setId(servicio.getId());
				formulario.setNombre(servicio.getNombre());
				formulario.setDescripcion(servicio.getDescripcion());
				formulario.setPrecio(servicio.getPrecio());
				formulario.setDuracion(servicio.getDuracion());
				formulario.setEstado(servicio.getEstado());
			}
			
		model.addAttribute(FORM_ATTRIBUTE, formulario);
		return PATH_PAGES_URL + "/form";
	}
	
	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save (@ModelAttribute(name = FORM_ATTRIBUTE) ServicioForm formulario) {
		Servicio servicio;
		String nombre = formulario.getNombre();
		String descripcion = formulario.getDescripcion();
		int precio = formulario.getPrecio();
		int duracion = formulario.getDuracion();
		String estado = "ACTIVO";
		
		if(formulario.esCreacion()) {
			servicio = new Servicio(nombre,descripcion,precio,duracion,estado);
		}else {
			servicio = this.servicio.obtenerServicio(formulario.getId());
			servicio.setNombre(nombre);
			servicio.setDescripcion(descripcion);
			servicio.setPrecio(precio);
			servicio.setDuracion(duracion);
			servicio.setEstado(estado);
		}
		
		this.servicio.guardarServicio(servicio);
		return "redirect:" + PATH_CONTEXT_URL;
	}
}
