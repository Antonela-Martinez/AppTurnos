package ar.com.am.clases;

public class DatosAcceso {
	private int id;
	private String mailUsuario;//
	private String clave;
	private boolean estado;//enum para definir estados, activo, inactivo, autorizado, pendiente 
	
	public DatosAcceso(String us, String contraseña) {
		this.mailUsuario = us;
		this.clave = contraseña;
	}
}
