package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Profesional;
import ar.com.am.helper.UsuarioHelper;

public class UsuarioEntityTest {

	@Test
	public void testTieneDniSucces() {
		
		Cliente c = new Cliente(12123123L);

		assertTrue(c.tieneDni(12123123L));
	}
	
	@Test
	public void testTieneDniFailure() {
		
		Cliente c = new Cliente(12123123L);

		assertFalse(c.tieneDni(22123123L));
	}
	
	@Test
	public void testTieneDni() {
		Cliente c = UsuarioHelper.createValidClient();
		Profesional p =  UsuarioHelper.createValidProf();
		//c.setDni(12345678L);

		assertTrue(c.tieneDni(12123123L));
	}

	
}