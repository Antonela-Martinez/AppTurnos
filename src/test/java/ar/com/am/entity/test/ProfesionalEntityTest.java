package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.DatosAcceso;
import ar.com.am.clases.Profesional;
import ar.com.am.helper.UsuarioHelper;

public class ProfesionalEntityTest extends UsuarioEntityTest<Profesional>{
	


	@Override
	protected Profesional crearUsuario() {
		return UsuarioHelper.createProfesionalValido();
	}
	
	
	
	@Test
	public void testTieneDni() {
		Profesional p =  UsuarioHelper.createProfesionalValido();
		assertTrue(p.tieneDni(12123123L));
	}
	
	@Test
	public void testSetDatosAccesoValido() {
		Profesional p = UsuarioHelper.createProfesionalValido();
		p.setAcceso(UsuarioHelper.creatDatosAccesoValido());
		DatosAcceso acceso = p.getAcceso();
		assertEquals(p.getAcceso(), acceso);
	}
	
	@Test
	public void testSetDatosAccesoNull() {
		try {
			Profesional p = UsuarioHelper.createProfesionalValido();
			p.setAcceso(null);
		}catch(IllegalArgumentException e) {
			assertEquals(Profesional.ERROR_MESSAGE_EMPTY_ACCESO,e.getMessage());
		}
	}

	//?????
	/*@Test
	public void testSetDatosAccesoEmpty() {
		try {
			Profesional p = UsuarioHelper.createProfesionalValido();
			p.setAcceso(UsuarioHelper.createDatosAccesoEmpty());
		}catch(IllegalArgumentException e) {
			assertEquals(Profesional.ERROR_MESSAGE_EMPTY_ACCESO, e.getMessage());
		}
	}*/
	
	public void testSetDatosAccesoEmailInvalido() {

	}
	


}
