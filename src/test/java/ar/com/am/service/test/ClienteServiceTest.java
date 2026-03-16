package ar.com.am.service.test;



import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.com.am.clases.Cliente;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.servicios.ClienteService;

@SpringBootTest//va a ser un test que necesita todo el contexto de spring para que este atributo pueda inicializarse correctamente
@ActiveProfiles("test")
public class ClienteServiceTest extends UserServiceTest<Cliente, ClienteService> {

	@Override
	protected Cliente obtenerUsuario() {
		Cliente usuario = UsuarioHelper.createValidClient();
		usuario.setNombre("Antonela");
		usuario.setApellido("Martinez");
	    usuario.setEmail("antonela@test.com");
	    usuario.setTelefono(224567896);
		return usuario;
	      
	}
	
	
	


}
