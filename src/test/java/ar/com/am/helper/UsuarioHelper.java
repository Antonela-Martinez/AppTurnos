package ar.com.am.helper;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.DatosAcceso;
import ar.com.am.clases.Profesional;
import ar.com.am.clases.Usuario;

public class UsuarioHelper {
	public static final Long VALID_USER_DNI = 12123123L;
	public static final String VALID_USER_EMAIL = "anto2026@gmail.com";
	public static final String VALID_USER_CLAVE = "1234";
	public static final DatosAcceso VALID_DATOS_ACCESO = new DatosAcceso(VALID_USER_EMAIL,VALID_USER_CLAVE);
	
	
	public final static Profesional createValidProf () {
		return new Profesional(VALID_USER_DNI,VALID_DATOS_ACCESO);
	}
	
	public final static Cliente createValidClient () {
		return new Cliente(VALID_USER_DNI);
	}
	
}
