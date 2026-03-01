package ar.com.am.clases;

public class Admin extends Profesional {
	public static final String DISCRIMINATOR_VALUE = "ADMIN";
	
	protected Admin() {
		super();
	}

	public Admin(Long dni, DatosAcceso acceso) {
		super(dni, acceso);
	}
	
	public Admin(Long dni,String nombre, String apellido, long telefono, DatosAcceso acceso, String dis) {
		super(dni, nombre, apellido, telefono,acceso,dis);
	}

}
