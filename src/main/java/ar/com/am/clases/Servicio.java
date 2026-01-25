package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table (name = "SERVICIOS")
public class Servicio extends Keyed{
	public static final String ERROR_MSG_NOMBRE_EMPTY_SERVICIO = "El nombre no puede estar vacío";
	private static final String ERROR_MSG_MAX_DESCRIPCION = "La descripción no puede superar los 255 caracteres";
	public static final String ERROR_MSG_PRECIO_INVALIDO = "El precio debe ser válido";
	public static final int CERO = 0;
	public static final int NUMERO_MAX = 99999999;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "precio")
	private int precio;
	@Column(name = "duracion")
	private int duracion;
	@Column(name = "estado")
	private boolean estado;
	
	Servicio(){
		
	}
	
	public Servicio(String n, int p) {
		setNombre(n);
		setPrecio(p); 
	}
	
	//NOMBRE SERVICIO
	public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MSG_NOMBRE_EMPTY_SERVICIO);
        }
        if (nombre.length() > Usuario.NUM_MAX_NAME) {
            throw new IllegalArgumentException(Usuario.ERROR_MESSAGE_MAX_CARACTER);
        }
        this.nombre = nombre; 
    }

    public String  getNombre() {
    	return nombre;
    }
	
	//DESCRIPCION SERVICIO
    public void setDescripcion(String desc) {
        if (desc == null || desc.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (desc.length() > 255) {
            throw new IllegalArgumentException(ERROR_MSG_MAX_DESCRIPCION);
        }
        this.descripcion = desc;
    }
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	//PRECIO
	public void setPrecio(int precio) {
	    if (precio < CERO || precio > NUMERO_MAX) {
	        throw new IllegalArgumentException(ERROR_MSG_PRECIO_INVALIDO);
	    }
	    this.precio = precio;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	//DURACION
	public void setDuracion(int duracion) {
	    if (duracion <= CERO) {
	        throw new IllegalArgumentException("La duración debe ser mayor a 0");
	    }
	    if (duracion > 500) { 
	        throw new IllegalArgumentException("La duración es demasiado larga");
	    }
	    this.duracion = duracion;
	}

	
	public int getduracion() {
		return this.duracion;
	}
	
	//ESTADO
	public void setEstado(boolean estado) {
	    this.estado = estado;
	}
	
	public boolean getEstado() {
		return estado;
	}

	//METODOS DE VALIDACION
	public boolean esServicioValido() {
	    return nombre != null && !nombre.trim().isEmpty()
	           && precio > CERO
	           && duracion > CERO;
	}

	public boolean estaActivo() {
	    return estado;
	}
	
	@Override
	public String toString() {
	    return "Servicio{" +
	           "nombre='" + nombre + '\'' +
	           ", precio=" + precio +
	           ", duracion=" + duracion +
	           ", estado=" + estado +
	           '}';
	}


}
