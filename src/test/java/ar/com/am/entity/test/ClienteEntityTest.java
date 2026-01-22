package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.Cliente;
import ar.com.am.helper.UsuarioHelper;

public class ClienteEntityTest extends UsuarioEntityTest<Cliente>{

	@Override
	protected Cliente crearUsuario() {
		
		return new Cliente(43777987L);
	}
	
	
	@Test
	public void testTieneDniSucces() {
		
		Cliente c = new Cliente(12123123L);

		assertTrue(c.tieneDni(12123123L));
	}
	
	@Test
	public void testTieneDni() {
		Cliente c = UsuarioHelper.createValidClient();

		assertTrue(c.tieneDni(12123123L));
	}


	
	
}
