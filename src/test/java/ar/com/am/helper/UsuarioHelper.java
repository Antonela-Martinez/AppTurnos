package ar.com.am.helper;

import java.util.Random;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.DatosAcceso;
import ar.com.am.clases.Profesional;


public class UsuarioHelper {
	private static final Random random = new Random(System.currentTimeMillis());
	
	private static final char[] caracteres = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m',
			 											'n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static final String[] invalidos = new String[]{
									            "@gmail.com",
									            "usuario@.com",
									            "usuario@gmail",
									            "usuario@gmail.c",
									            "usu@rio@gmail.com",
									            "usuario@dominio..com",
									            "usuario@dominio_com",
									            "usuario gmail.com",
									            "usuario@dominio.c0m"
									        };
	public static final Long VALID_USER_DNI = 12123123L;
	public static final String VALID_USER_EMAIL = "anto2026@gmail.com";
	public static final String VALID_USER_CLAVE = "Anto1234";
	public static final String NOMBRE = "Mirian";
	public static final String APELLLIDO = "Lopez";
	public static final long TELEFONO = 22367543;
	public static final String EMAIL = "miriam@gmail.com";
	public static final String DISCRIMINADOR = "PROFESIONAL";
	
	
	public final static DatosAcceso creatDatosAccesoValido() {
		return new DatosAcceso(VALID_USER_EMAIL,VALID_USER_CLAVE);
	}
	
	public final static DatosAcceso createDatosAccesoEmpty() {
		return new  DatosAcceso(" "," ");
	}
	
	
	public final static Profesional createProfesionalValido () {
		return new Profesional(VALID_USER_DNI,NOMBRE,APELLLIDO,TELEFONO,UsuarioHelper.creatDatosAccesoValido(),DISCRIMINADOR);
	}
	
	public final static Cliente createValidClient () {
		return new Cliente(VALID_USER_DNI,NOMBRE,APELLLIDO,TELEFONO,EMAIL);
	}
	
	
//--------***CLAVE***----
	
	public final static String createClave() {
		return "Prueba123";
	}
	
	public final static String createClaveCorta() {
		return "An1";
	}
	
	public final static String createClaveLarga() {
		return "An1".repeat(10);
	}
	
	public final static String createClaveSinMayuscula() {
		return "n1".repeat(5);
	}
	
	public final static String createClaveSinNumero() {
		return "An".repeat(5);
	}
	
	public final static String createClaveSinCaracter() {
		return "1".repeat(10);
	}
	
	
	
	
//-----***EMAIL****----
	public final static String createEmail() {
		return "mail"+random.nextInt()+"@mail.com";
	}
	
	public final static String createEmailInvalido(int pos) {
		return invalidos[pos];
	}
	
	public final static String createEmail(int cantCaracteres) {
		String email = "@mail.com";
		int cant = cantCaracteres + email.length();
		
		for(int i = 0 ; i < cant ; i++) {
			int pos = random.nextInt(caracteres.length);
			email = caracteres[pos] + email;
		}
		
		return email;
	}
	
}
