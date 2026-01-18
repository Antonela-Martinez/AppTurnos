package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

//para decirle a hibernate que esta entidad es persistida
@Entity
//en que tabla se van a guardar los datos de los objetos usuarios
@Table(name = "USUARIOS")
@Inheritance(strategy =InheritanceType.JOINED )
public abstract class Usuario extends Keyed {
	@Column(name = "dni")
	private Long dni;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido; 
	@Column(name = "telefono")
	private long telefono;
	
	//Solo para hibernate
	Usuario(){
		
	}
	
	public Usuario (Long dni) {
		this.dni = dni;
	}
	
    // Setter
    public void setDni(Long dni) {
		if (dni == null) {
			throw new IllegalArgumentException("El mail no debe ser nulo");
		}
		
		this.dni = dni;
	}
    
    // Getter 
    public Long getDni() {
        return dni;
    }
    
    public void setNombre(String nombre) {
    	this.nombre=nombre;
    }
    
    public String  getNombre() {
    	return nombre;
    }
    
    
    public boolean tieneDni(Long dni) {
  		return this.dni.equals(dni);
  	}

}
