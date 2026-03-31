package ar.com.am.repository.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Usuario;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.repositorios.ClienteRepository;
import ar.com.am.repositorios.ProfesionalRepository;
import ar.com.am.repositorios.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
public abstract class UserRepositoryTest < T extends Usuario, R extends UserRepository<T>> {
	@Autowired
	private R repository; 
	
	protected abstract T obtenerUsuario();  
	
	@Test
	public T testEncontrarPorDNI() {
		
        T usuario = obtenerUsuario();
        this.repository.guardar(usuario);
        
		List<T> listatest = repository.findByDni(profesional.getDni);
		if (listatest.isEmpty()) return null;
		if (listatest.size() > 1) throw new RuntimeException("Mas d eun usuario con este dni");
		
	    return listatest.get(0);
	}
	
	/*
	@Test
	public void testSaveRepositoryClienteSucces() {
		Cliente usuario = UsuarioHelper.createValidClient();
        this.clienteRepository.save(usuario);
	}
	
	@Test
	public void testSaveClientNull() {
		try {
			this.clienteRepository.save(null);
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
        
        this.profRepository.save(profesional);
	}
	
	@Test
	public void testSaveProfesionalNull() {
		try {
			this.profRepository.save(null);
			fail("No se puede persistir una entidad nula");
		}catch(Exception e) {
			e.getMessage();
		}
	}
	*/

}
