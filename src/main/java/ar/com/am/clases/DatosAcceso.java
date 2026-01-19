package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table (name = "DATOS_ACCESO")
public class DatosAcceso extends Keyed{
	@Column(name = "email_us")
	private String emailUsuario;
	@Column(name = "clave")
	private String clave;
	@Column(name = "estado")
	private boolean estado;
	//@Enumerated(EnumType.STRING)
	//private EstadoAcceso estado;//enum para definir estados, activo, inactivo, autorizado, pendiente 
	
	public DatosAcceso(String us, String contraseña) {
		this.emailUsuario = us;
		this.clave = contraseña;
	}
	
	//email usuario
	public String getEmailUsr() {
		return this.emailUsuario;
	}
	
	public void setEmailUsr(String email_U) {
	    if (email_U == null || email_U.trim().isEmpty()) {
	        throw new IllegalArgumentException("El email no puede estar vacío");
	    }
	    if (!email_U.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
	        throw new IllegalArgumentException("Formato de email inválido");
	    }
	    this.emailUsuario = email_U;
	}

	
	//CLAVE
	public String getclave() {
		return this.clave;
	}
	
	public void setClave(String clave) {
	    if (clave == null || clave.trim().isEmpty()) {
	        throw new IllegalArgumentException("La clave no puede estar vacía");
	    }
	    if (clave.length() < 8) {
	        throw new IllegalArgumentException("La clave debe tener al menos 8 caracteres");
	    }
	    if (!clave.matches(".*[A-Z].*")) {
	        throw new IllegalArgumentException("La clave debe contener al menos una letra mayúscula");
	    }
	    if (!clave.matches(".*[0-9].*")) {
	        throw new IllegalArgumentException("La clave debe contener al menos un número");
	    }
	    this.clave = clave;
	}

	
	//ESTADO
	public boolean getEstado () {
		return this.estado;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	//METODOS DE VALIDACION
	public boolean esEmailValido() {
	    return emailUsuario != null && emailUsuario.matches("^[A-Za-z0-9+_.-]+@(.+)$");
	}

	public boolean esClaveValida() {
	    return clave != null && clave.length() >= 8 &&
	           clave.matches(".*[A-Z].*") &&
	           clave.matches(".*[0-9].*");
	}
	
}
