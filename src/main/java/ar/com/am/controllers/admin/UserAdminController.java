package ar.com.am.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.am.clases.Admin;
import ar.com.am.clases.DatosAcceso;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Usuario;
import ar.com.am.forms.UserForm;
import ar.com.am.servicios.UserService;

@Controller
public class UserAdminController {
	private static final String LIST_ATTRIBUTE = "listado";
	private static final String FORM_ATTRIBUTE = "form";
	private static final String PATH_PAGES_URL = "/admin/users";
	private static final String PATH_CONTEXT_URL = "/admin/users";
	@Autowired
	private UserService servicio; 

	/*@GetMapping(value = PATH_CONTEXT_URL)
	public String init (Model model) {
		List<Usuario> usuarios = this.servicio.listAll();
		model.addAttribute(LIST_ATTRIBUTE,usuarios);
		return PATH_PAGES_URL + "/list";
	}*/
	
	@GetMapping(value = PATH_CONTEXT_URL)
	public String listarProfesionales(Model model) {
	    List<Usuario> usuarios = this.servicio.listAll();

	    // Lista vacía para acumular solo profesionales
	    List<Profesional> profesionales = new ArrayList<>();

	    // Condicional simple
	    for (Usuario u : usuarios) {
	        if (u instanceof Profesional) {
	            profesionales.add((Profesional) u);
	        }
	    }

		model.addAttribute(LIST_ATTRIBUTE,profesionales);
		return PATH_PAGES_URL + "/list";
	}

	
	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit (Model model) {
		model.addAttribute(FORM_ATTRIBUTE, new UserForm());
		return PATH_PAGES_URL + "/form";
	}
	
	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save (@ModelAttribute(name = FORM_ATTRIBUTE) UserForm formulario) {
		
		Long dni = formulario.getDni();
		long telefono = formulario.getTelefono();
		String nombre = formulario.getNombre();
		String apellido = formulario.getApellido();
		String email = formulario.getEmail();
		String clave = formulario.getClave();
		boolean isAdmin = formulario.getIsAdmin();
		
		DatosAcceso acceso = new DatosAcceso(email,clave);
		Profesional p;
		
			if(isAdmin) {
				p = new Admin(dni,nombre,apellido,telefono,acceso,"ADMIN");
			}else {
				p = new Profesional(dni,nombre,apellido,telefono,acceso,"PROFESIONAL");
				
			}
		
		this.servicio.guardarUsuario(p);
		return "redirect:" + PATH_CONTEXT_URL;
	}
	

}
