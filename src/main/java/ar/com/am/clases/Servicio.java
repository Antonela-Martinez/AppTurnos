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
}
