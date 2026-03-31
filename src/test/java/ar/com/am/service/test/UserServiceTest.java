package ar.com.am.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.am.clases.Usuario;
import ar.com.am.servicios.UserService;


public abstract class UserServiceTest<T extends Usuario, S extends UserService<T>> {
	//a traves de Sprin vamos a inyectar una instancia del servicio del usuario para inicializarlo
	//@Autowired
	//private UserService servicio; //voy a necesitar una instancia de este tipo de dato
	@Autowired
	private S servicio;
	
	protected abstract T obtenerUsuario();
	
	@Test
	public void testSaveClienteSucces() {
        T usuario = obtenerUsuario();
        this.servicio.guardar(usuario);
	}

	public void testListAllUsuarios() {
		this.servicio.listAll();
	}

}
