package ar.com.am.clases;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROFESIONALES")
public class Profesional extends Usuario {
	public static final String ERROR_MESSAGE_EMPTY_ACCESO= "Los datos de acceso no pueden ser nulos";
	public static final String ERROR_MESSAGE_INVALID = "Email o clave no son correctos";
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "datos_acceso_id", referencedColumnName = "ID")
	private DatosAcceso acceso;
	@Column(name = "discriminator")
	private String isAdmimn;
	
	
	protected Profesional(){
		super();
	}
	
	public Profesional(Long dni, DatosAcceso acceso) {
		super(dni);
		setAcceso(acceso);
	}
	
	public Profesional(Long dni,String nombre, String apellido, long telefono, DatosAcceso acceso, String discriminador) {
		super(dni, nombre, apellido, telefono);
		setAcceso(acceso);
		setIsAdmin(discriminador);;
	}
	
	//ACCESO
	public DatosAcceso getAcceso() {
		return this.acceso;
	}
	
	public void setAcceso(DatosAcceso ac) {
	    if (ac == null) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_ACCESO);
	    }
	    if (!ac.esEmailValido() || !ac.esClaveValida()) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_INVALID);
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

	/*public boolean esAdmin() {
	    return "ADMIN".equalsIgnoreCase(isAdmimn);
	}*/
	

	public String toString() {
		return "Profesional: "+getDni()+ "| Nombre: "+ getNombre();
	}
	
	@Override
	public boolean equals(Object o) {
		Profesional p = (Profesional) o;
		return super.equals(o)	&& this.acceso.equals(p.getAcceso());
	}
}

