package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "DATOS_ACCESO")
public class DatosAcceso {
	@Id 
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "email_us")
	private String emailUsuario;
	@Column(name = "clave")
	private String clave;
	@Column(name = "estado")
	private boolean estado;//enum para definir estados, activo, inactivo, autorizado, pendiente 
	
	public DatosAcceso(String us, String contraseña) {
		this.emailUsuario = us;
		this.clave = contraseña;
	}
}
