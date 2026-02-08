package ar.com.am.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaAdminController {
	
	@GetMapping("/admin/dashboard")
	public String dashboardInit() {
		return "/admin/user/dash";
	}

	@GetMapping("/admin/reserva")
	public String init () {
		return "list";
	}
	
	
}
