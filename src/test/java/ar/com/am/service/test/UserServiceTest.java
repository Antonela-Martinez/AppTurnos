package ar.com.am.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.helper.UsuarioHelper;
import ar.com.am.servicios.UserService;

@SpringBootTest//va a ser un test que necesita todo el contexto de spring para que este atributo pueda inicializarse correctamente
public class UserServiceTest {
	//a traves de Sprin vamos a inyectar una instancia del servicio del usuario para inicializarlo
	@Autowired
	private UserService servicio; //voy a necesitar una instancia de este tipo de dato
	
	
	@Test
	public void testSaveClienteSucces() {
		Cliente usuario = UsuarioHelper.createValidClient();
		usuario.setNombre("Antonela");
		usuario.setApellido("Martinez");
        usuario.setEmail("antonela@test.com");
        usuario.setTelefono(224567896);
        
        this.servicio.guardarUsuario(usuario);
		
        /*try {
            this.servicio.guardarUsuario(usuario);
         } catch (Exception e) {
             e.printStackTrace();
         }*/
	}
	
	@Test
	public void testSaveProfesionalSucces() {
		Profesional profesional = UsuarioHelper.createProfesionalValido();
		profesional.setNombre("Laura");
		profesional.setApellido("Mendez");
        profesional.setAcceso(UsuarioHelper.creatDatosAccesoValido());
        profesional.setTelefono(224567777);
        profesional.setIsAdmin("PROFESIONAL");
        
        this.servicio.guardarUsuario(profesional);
		

	}
	

	




}
