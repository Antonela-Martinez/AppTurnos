package ar.com.am.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.am.clases.Usuario;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.servicios.UserService;

@SpringBootTest //va a ser un test que necesita todo el contexto de spring para que este atributo pueda inicializarse correctamente
public class UserServiceTest {
	//a traves de Sprin vamos a inyectar una instancia del servicio del usuario para inicializarlo
	@Autowired
	private UserService servicio; //voy a necesitar una instancia de este tipo de dato
	
	/*private Usuario crearUsuario() {
		return T Usuario(Long);
	}*/
	
	@Test
	public void testSaveClienteSucces() {
		Usuario usuario = UsuarioHelper.createValidClient();
		
		this.servicio.guardarUsuario(usuario);
	}



}
