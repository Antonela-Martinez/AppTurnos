package ar.com.am.clases;

import jakarta.persistence.DiscriminatorValue;
//import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = Admin.DISCRIMINATOR_VALUE)
public class Admin extends Profesional {
	public static final String DISCRIMINATOR_VALUE = "ADMIN";

	public Admin(Long dni, DatosAcceso acceso) {
		super(dni, acceso);
	}

}
