package ar.com.am.clases;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
//import jakarta.persistence.DiscriminatorValue;

//@Entity
@DiscriminatorValue(value = Admin.DISCRIMINATOR_VALUE)
public class Admin extends Profesional {
	public static final String DISCRIMINATOR_VALUE = "ADMIN";

	public Admin(Long dni, DatosAcceso acceso) {
		super(dni, acceso);
	}
	
	public Admin(Long dni,String nombre, String apellido, long telefono, DatosAcceso acceso) {
		super(dni, nombre, apellido, telefono,acceso);
	}

}
