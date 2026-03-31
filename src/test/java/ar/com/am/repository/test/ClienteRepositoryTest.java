package ar.com.am.repository.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Cliente;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.repositorios.ClienteRepository;

@SpringBootTest
@ActiveProfiles(value = "test")
public class ClienteRepositoryTest extends UserRepositoryTest<Cliente,ClienteRepository> {
	
	protected Cliente obtenerUsuario() {
		Cliente usuario = UsuarioHelper.createValidClient();
		usuario.setNombre("Antonela");
		usuario.setApellido("Martinez");
	    usuario.setEmail("antonela@test.com");
	    usuario.setTelefono(224567896);
		return usuario;
	      
	}



/*	@Test
	public void testSaveRepositoryClienteSucces() {
		Cliente c = UsuarioHelper.createValidClient();
        this.clienteRepository.save(c);
	}
	
	@Test
	public void testSaveClientNull() {
		try {
			this.clienteRepository.save(null);
			fail("No se puede persistir una entidad nula");
		}catch(Exception e) {
			e.getMessage();
		}
	}*/
}
