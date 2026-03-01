package ar.com.am.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Reserva;
import ar.com.am.clases.Servicio;
import ar.com.am.helper.ReservaHelper;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.repositorios.BookingRepository;
import ar.com.am.repositorios.ServiceRepository;
import ar.com.am.repositorios.UserRepository;


@SpringBootTest
@ActiveProfiles("test")
public class BookingRepositoryTest {
	
	@Autowired
	private BookingRepository repository;
	@Autowired
	private  UserRepository userRepository;
	@Autowired
	private ServiceRepository servicioRepository;
	
	@Test
	public void testSaveRepositoryReservasSucces() {
		Profesional profesional =  userRepository.loadById(4L);
		Servicio servicio = servicioRepository.loadById(1L);
		
		Cliente cliente = (Cliente) this.userRepository.findByDni(1L);
		if(cliente==null) {
			cliente = UsuarioHelper.createValidClient();
		}
	
		
		Reserva reserva = ReservaHelper.createReservaValida(profesional,servicio,cliente);
		this.repository.save(reserva);	
	}

}
