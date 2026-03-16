package ar.com.am.repository.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

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
import ar.com.am.repositorios.ClienteRepository;
import ar.com.am.repositorios.ProfesionalRepository;
import ar.com.am.repositorios.ServiceRepository;


@SpringBootTest
@ActiveProfiles("test")
public class BookingRepositoryTest {
	
	@Autowired
	private BookingRepository repository;
	@Autowired
	private  ClienteRepository clienteRepository;
	@Autowired
	private  ProfesionalRepository profesionalRepository;
	@Autowired
	private ServiceRepository servicioRepository;
	
	@Test
	public void testSaveRepositoryReservasSucces() {
		Optional<Profesional> profesional =  profesionalRepository.findById(4L);
		if(profesional.isEmpty()) {
			fail("No se puede correr el test si esta vacio");
		}
	
		Optional<Servicio> servicio = servicioRepository.findById(1L);
		if(servicio.isEmpty()) {
			fail("No se puede correr el test si esta vacio");
		}
		
		Cliente cliente = (Cliente) this.clienteRepository.findByDni(1L);
		if(cliente==null) {
			cliente = UsuarioHelper.createValidClient();
		}
	
		
		Reserva reserva = ReservaHelper.createReservaValida(profesional.get(),servicio.get(),cliente);
		this.repository.save(reserva);	
	}

}
