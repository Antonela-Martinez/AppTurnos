package ar.com.am.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.repositorios.UserRepository;

@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository; 
	
	
	@Test
	public void testSaveRepositoryClienteSucces() {
		Cliente usuario = UsuarioHelper.createValidClient();
		usuario.setNombre("Maria");
		usuario.setApellido("Gallardo");
        usuario.setEmail("gallardo@test.com");
        usuario.setTelefono(224577796);
        this.repository.save(usuario);
	}
	
	public void testSaveClientNull() {
		this.repository.save(null);
	}
	
	@Test
	public void testSaveProfesionalRepositorySucces() {
		Profesional profesional = UsuarioHelper.createProfesionalValido();
		profesional.setNombre("Celeste");
		profesional.setApellido("Diaz");
        profesional.setAcceso(UsuarioHelper.creatDatosAccesoValido());
        profesional.setTelefono(224398989);
        //profesional.setIsAdmin("PROFESIONAL");
        
        this.repository.save(profesional);
		

	}
}
