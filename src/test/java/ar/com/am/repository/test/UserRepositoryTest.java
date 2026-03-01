package ar.com.am.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Usuario;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.repositorios.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository; 
	
	
	@Test
	public void testSaveRepositoryClienteSucces() {
		Cliente usuario = UsuarioHelper.createValidClient();
        this.repository.save(usuario);
	}
	
	@Test
	public void testSaveClientNull() {
		try {
			this.repository.save(null);
			fail("No se puede persistir una entidad nula");
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	@Test
	public void obtenerUserSuccess() {
		Long id= 4L;
		//Usuario user = this.repository.getReferenceById(id);
		Optional<Usuario> user = this.repository.findById(id);
	
		assertNotNull(user);
		assertEquals("Laura", user.get());
	}
	
	@Test
	public void testSaveProfesionalRepositorySucces() {
		Profesional profesional = UsuarioHelper.createProfesionalValido();
		profesional.setNombre("Celeste");
		profesional.setApellido("Diaz");
        profesional.setAcceso(UsuarioHelper.creatDatosAccesoValido());
        profesional.setTelefono(224398989);
        profesional.setIsAdmin("PROFESIONAL");
        
        this.repository.save(profesional);
	}
	
	@Test
	public void testSaveProfesionalNull() {
		try {
			this.repository.save(null);
			fail("No se puede persistir una entidad nula");
		}catch(Exception e) {
			e.getMessage();
		}
	}

}
