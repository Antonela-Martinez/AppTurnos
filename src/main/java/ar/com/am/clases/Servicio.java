package ar.com.am.clases;

public class Servicio {
	private int id;
	private String nombre;
	private String descripcion;
	private int duracion;
	private int precio;
	private boolean estado;
	
	
	public Servicio(String n, int p) {
		this.nombre = n;
		this.precio = p;
	}
}
