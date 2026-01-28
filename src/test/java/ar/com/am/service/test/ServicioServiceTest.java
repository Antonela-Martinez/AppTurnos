package ar.com.am.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.am.clases.Servicio;
import ar.com.am.helper.ServicioHelper;
import ar.com.am.servicios.ServiceService;

@SpringBootTest
public class ServicioServiceTest {
	@Autowired
	private ServiceService servicio ;
	
	@Test
	public void testSaveServiciosSucces() {
		Servicio servicio = ServicioHelper.createServicioValido();
        this.servicio.guardarServicio(servicio);
	}

}
