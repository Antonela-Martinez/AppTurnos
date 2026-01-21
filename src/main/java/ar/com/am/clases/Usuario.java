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
	
	//Constructor
	public Usuario (Long dni) {
		this.dni = dni;
	}
	
	
	
    // SetterDNI
	public void setDni(Long dni) {
	    if (dni == null || dni < 1000000 || dni > 99999999) {
	        throw new IllegalArgumentException("El DNI debe ser numérico y válido");
	    }
	    this.dni = dni;
	}

	//Sobre carga de metodo por si es un string para pasarlo a Long
	/*public void setDni(String dniStr) {
	    try {
	        this.dni = Long.parseLong(dniStr);
	    } catch (NumberFormatException e) {
	        throw new IllegalArgumentException("El DNI debe ser numérico");
	    }
	}*/

    // Getter DNI
    public Long getDni() {
        return dni;
    }
    

    
    //NOMBRE
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre no puede superar los 50 caracteres");
        }
        this.nombre = nombre;
    }

    public String  getNombre() {
    	return nombre;
    }
    
    
    
    
    //APELLIDO
    public void setApellido(String apellido) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre no puede superar los 50 caracteres");
        }
        this.apellido = apellido;
    }

    
    public String  getApellido() {
    	return apellido;
    }
    
    
    //TELEFONO
    public void setTelefono(long telefono) {
        if (telefono <= 0) {
            throw new IllegalArgumentException("El teléfono no puede ser nulo ni negativo");
        }
        int longitud = String.valueOf(telefono).length();
        if (longitud < 7 || longitud > 15) {
            throw new IllegalArgumentException("El teléfono debe tener entre 7 y 15 dígitos");
        }
        this.telefono = telefono;
    }

    
    public long  getTelefono() {
    	return telefono;
    }
    
    // METODOS DE VALIDACION
    public boolean tieneDni(Long dni) {
        return this.dni != null && this.dni.equals(dni);
    }

    public boolean esDniValido() {
        return dni != null && dni > 1000000 && dni < 99999999;
    }

    public boolean tieneNombreValido() {
        return nombre != null && !nombre.trim().isEmpty();
    }

    

    
    @Override
    public String toString() {
        return "Usuario{" +
               "dni=" + dni +
               ", nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", telefono=" + telefono +
               '}';
    }


}
