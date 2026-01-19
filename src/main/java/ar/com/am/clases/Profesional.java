package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROFESIONALES")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
//Discrimina si tiene que crear un objeto profesional o un objeto admin ??? hibernate nos ofrece los tipo de discriminador que pueden ser
@DiscriminatorColumn(name="discriminator",discriminatorType = DiscriminatorType.STRING)
public class Profesional extends Usuario {
	@Column(name = "datos_acceso_id")
	private DatosAcceso acceso;
	//@Column(name = "isAdmin")
	@Column(name = "discriminator")
	private String isAdmimn;
	
	public Profesional(Long dni, DatosAcceso acceso) {
		super(dni);
		this.acceso = acceso;
	}
	
	//ACCESO
	public DatosAcceso getAcceso() {
		return this.acceso;
	}
	
	public void setAcceso(DatosAcceso ac) {
	    if (ac == null) {
	        throw new IllegalArgumentException("Los datos de acceso no pueden ser nulos");
	    }
	    if (!ac.esEmailValido() || !ac.esClaveValida()) {
	        throw new IllegalArgumentException("Los datos de acceso no son válidos");
	    }
	    this.acceso = ac;
	}
	
	//ISADMIN
	public String getIsAdmin() {
		return this.isAdmimn;
	}
	
	public void setIsAdmin(String isAdmin) {
		this.isAdmimn = isAdmin;
	}
	
	
	//METODOS DE VALIDACION
	public boolean tieneAccesoValido() {
	    return acceso != null 
	           && acceso.esEmailValido() 
	           && acceso.esClaveValida();
	}
	
	public boolean esProfesionalValido() {
	    return esDniValido() && tieneAccesoValido();
	}

	public boolean esAdmin() {
	    return "ADMIN".equalsIgnoreCase(isAdmimn);
	}
	

	public String toString() {
		return "Profesional: "+getDni()+ "| Nombre: "+ getNombre();
	}
	
	
	public void iniciarSesion() {
		
	}
	
	public void verAgenda() {
		
	}
}

