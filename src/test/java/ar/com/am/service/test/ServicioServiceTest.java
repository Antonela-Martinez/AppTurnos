package ar.com.am.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Servicio;
import ar.com.am.helper.ServicioHelper;
import ar.com.am.servicios.ServiceService;

@SpringBootTest
@ActiveProfiles(value = "test")
public class ServicioServiceTest {
	@Autowired
	private ServiceService servicio ;
	
	@Test
	public void testSaveServiciosSucces() {
		Servicio servicio = ServicioHelper.createServicioValido();
        this.servicio.guardarServicio(servicio);
	}
	
	@Test
	public void testListAllServicios() {
        this.servicio.listAll();
	}

}
