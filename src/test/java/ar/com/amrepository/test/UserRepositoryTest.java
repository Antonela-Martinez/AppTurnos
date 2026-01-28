package ar.com.amrepository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.am.clases.Cliente;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.servicios.UserService;

@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserService servicio;
	
	@Test
	public void testSaveClienteSucces() {
		Cliente usuario = UsuarioHelper.createValidClient();
		usuario.setNombre("Antonela");
		usuario.setApellido("Martinez");
        usuario.setEmail("antonela@test.com");
        usuario.setTelefono(224567896);
        
        try {
           this.servicio.guardarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

	
	}
}
