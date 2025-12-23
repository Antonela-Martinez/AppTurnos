package ar.com.am.clases;

public class Profesional extends Usuario {
	private DatosAcceso acceso;
	
	public Profesional(int dni, DatosAcceso acceso) {
		super(dni);
		this.acceso = acceso;
	}
	
	//Tengo que hacer un metodo get del atributo acceso para acceder desde admin?

	public void iniciarSesion() {
		
	}
	
	public void verAgenda() {
		
	}
}
