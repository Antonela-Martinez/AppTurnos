package ar.com.am.entity.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.am.clases.DatosAcceso;
import ar.com.am.clases.Profesional;
import ar.com.am.helper.UsuarioHelper;

public class ProfesionalEntityTest extends UsuarioEntityTest<Profesional>{
	public static final Long VALID_USER_DNI = 12123123L;
	public static final String VALID_USER_EMAIL = "anto2026@gmail.com";
	public static final String VALID_USER_CLAVE = "1234";
	public static final DatosAcceso VALID_DATOS_ACCESO = new DatosAcceso(VALID_USER_EMAIL,VALID_USER_CLAVE);

	@Override
	protected Profesional crearUsuario() {
		// TODO Auto-generated method stub
		return new Profesional(VALID_USER_DNI,VALID_DATOS_ACCESO);
	}
	
	
	@Test
	public void testTieneDniFailure() {
		
		Profesional p = new Profesional(13123123L, null);

		assertFalse(p.tieneDni(22123123L));
	}
	
	@Test
	public void testTieneDni() {
	
		Profesional p =  UsuarioHelper.createValidProf();
		

		assertTrue(p.tieneDni(12123123L));
	}

	@Override
	public void testTieneDniSucces() {
		// TODO Auto-generated method stub
		
	}

}
