package ar.com.am.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Servicio;
import ar.com.am.helper.ServicioHelper;
import ar.com.am.repositorios.ServiceRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ServiceRepositoryTest {
	
	@Autowired
	private ServiceRepository repository ;
	
	@Test
	public void testSaveRepositorySucces() {
		Servicio servicio = ServicioHelper.createServicioValido();
        this.repository.save(servicio);
	}

}
