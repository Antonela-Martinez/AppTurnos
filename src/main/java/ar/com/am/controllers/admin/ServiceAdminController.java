package ar.com.am.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceAdminController {
	private static final String PATH_PAGES_URL = "/admin/servicios";
	private static final String PATH_CONTEXT_URL = "/admin/service";
	
	
	@GetMapping(value = PATH_CONTEXT_URL)
	public String init () {
		return PATH_PAGES_URL + "/list";
	}

	
	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit () {
		return PATH_PAGES_URL + "/form";
	}
}
