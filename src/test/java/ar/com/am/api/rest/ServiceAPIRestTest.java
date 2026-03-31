package ar.com.am.api.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.dtos.ServicioDTO;
import tools.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles(value = "test")
public class ServiceAPIRestTest {
	
	@LocalServerPort
	private int port;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void listServicios() {
		URI uri = URI.create("http://localhost:" + this.port +ServicioAPIRestService.API_SERVICIO_URL_PATH);
		
		HttpRequest request = HttpRequest.
								newBuilder(uri).
								GET().
								header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).
								build();
		
		try {
			
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			List<ServicioDTO> servicios = mapper.readerForListOf(ServicioDTO.class).readValue(response.body());
			
			assertNotNull(servicios);
			assertEquals(58,servicios.size());
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
	}
}
