package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table (name = "SERVICIOS")
public class Servicio extends Keyed{
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
		this.nombre = n;
		this.precio = p;
	}
	
	//NOMBRE SERVICIO
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
	
	//DESCRIPCION SERVICIO
    public void setDescripcion(String desc) {
        if (desc == null || desc.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (desc.length() > 255) {
            throw new IllegalArgumentException("La descripción no puede superar los 255 caracteres");
        }
        this.descripcion = desc;
    }
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	//PRECIO
	public void setPrecio(int precio) {
	    if (precio < 0 || precio > 99999999) {
	        throw new IllegalArgumentException("El precio debe ser numérico y válido");
	    }
	    this.precio = precio;
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	//DURACION
	public void setDuracion(int duracion) {
	    if (duracion <= 0) {
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
	           && precio > 0
	           && duracion > 0;
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
