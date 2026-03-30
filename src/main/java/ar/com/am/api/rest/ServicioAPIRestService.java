package ar.com.am.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ar.com.am.dtos.ServicioDTO;
import ar.com.am.forms.ServicioForm;
import ar.com.am.servicios.ServiceService;

@RestController
public class ServicioAPIRestService {
	public static final String URL_PATH = "/api";
	public static final String API_SERVICIO_URL_PATH = URL_PATH + "/servicios";
	@Autowired
	private ServiceService servicioService;
	
	//lo que va a ir adentro de la respuesta va a ser una coleccion de tipo Servicios
	@GetMapping(value = API_SERVICIO_URL_PATH, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServicioDTO>> list() {
		List<ServicioDTO> servicios = this.servicioService.listAll();
		
		//Spring va a formar una respuesta con codigo http 200, va a serializar todos los objetos resultados
		//y ese HTTP response va a viajar hacia el destino que invoco nuestro servicio
		return ResponseEntity.ok(servicios);
	}
	
	
	@PostMapping(value="/api/servicios/save", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody ServicioForm formulario) {
		formulario.getNombre();
		return ResponseEntity.ok("Todo ok");
	}

}
