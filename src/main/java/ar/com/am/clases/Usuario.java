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
	
	private static final Long MAX_VALOR_DNI = 99999999L;
	private static final Long MIN_VALOR_DNI = 1000000L;
	public static final String ERROR_MESSAGE_DNI = "El DNI debe ser numérico y válido";
	public static final String ERROR_MESSAGE_EMPTY = "El campo no puede estar vacío";
	protected static final int NUM_MAX_NAME = 50;
	public static final String ERROR_MESSAGE_MAX_CARACTER = "El texto no puede superar los 50 caracteres";
	public static final String ERROR_MESSAGE_TELEFONO = "El teléfono debe tener entre 7 y 15 dígitos";
	protected static final int NUM_NULO_TELEFONO= 0;
	private static final int NUM_MIN_TELEFONO = 7;
	private static final int NUM_MAX_TELEFONO = 15;
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
		setDni(dni);
	}
	
	
	
    // SetterDNI
	public void setDni(Long dni) {
	    if (dni == null || dni < MIN_VALOR_DNI || dni > MAX_VALOR_DNI) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_DNI );
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
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY);
        }
        if (nombre.length() > NUM_MAX_NAME ) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MAX_CARACTER );
        }
        this.nombre = nombre;
    }

    public String  getNombre() {
    	return nombre;
    }
    
    
    
    
    //APELLIDO
    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY);
        }
        if (apellido.length() > NUM_MAX_NAME) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MAX_CARACTER);
        }
        this.apellido = apellido;
    }

    
    public String  getApellido() {
    	return apellido;
    }
    
    
    //TELEFONO
    public void setTelefono(long telefono) {
        if (telefono <= NUM_NULO_TELEFONO) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY);
        }
        int longitud = String.valueOf(telefono).length();
        if (longitud < NUM_MIN_TELEFONO || longitud > NUM_MAX_TELEFONO) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TELEFONO);
        }
        this.telefono = telefono;
    }

    
    public long  getTelefono() {
    	return telefono;
    }
    
    // METODOS DE VALIDACION al pepe, va a dar siempre correctos porque la validacion esta en el set
    //y al crear un usuario con set siempre va a ser un usuario correcto
    public boolean tieneDni(Long dni) {
        return this.dni != null && this.dni.equals(dni);
    }

    public boolean esDniValido() {
        return dni != null && dni > MIN_VALOR_DNI && dni < MAX_VALOR_DNI;
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
