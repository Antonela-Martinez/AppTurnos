package ar.com.am.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.am.forms.ReservaForm;


@Controller
public class ReservaController {
	
	@GetMapping("/reserva/init")
	public String init(Model model) {//para acceder al modelo de la capa de vista
		
		model.addAttribute("form", new ReservaForm());
		return "/reservas/init";
	}
	
	
	@PostMapping("/reserva/iniciar")
	public String iniciar(ReservaForm formulario) {
		formulario.getUsername();
		return "/reservas/succes";
	}
	
}
