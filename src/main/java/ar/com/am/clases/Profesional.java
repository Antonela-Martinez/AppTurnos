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
	
	public String toString() {
		return "Profesional: "+getDni()+ "| Nombre: "+ getNombre();
	}
	
	//Tengo que hacer un metodo get del atributo acceso para acceder desde admin?

	public void iniciarSesion() {
		
	}
	
	public void verAgenda() {
		
	}
}
