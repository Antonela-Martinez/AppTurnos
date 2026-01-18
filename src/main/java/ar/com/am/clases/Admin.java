package ar.com.am.clases;

//import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue(Value=0)
public class Admin extends Profesional {

	public Admin(Long dni, DatosAcceso acceso) {
		super(dni, acceso);
	}

}
