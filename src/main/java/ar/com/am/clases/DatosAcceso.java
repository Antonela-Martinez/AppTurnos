package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table (name = "DATOS_ACCESO")
public class DatosAcceso extends Keyed{
	private static final String MESSAGE_EMPTY_FIELD = "El email no puede estar vacío";
	private static final String MESSAGE_INVALID_FORMAT_EMAIL = "Formato de email inválido";
	public final String FORMAT_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
	private static final String ERROR_MESSAGE_MIN_CARACTER = "La clave debe tener al menos 8 caracteres";
	private static final int NUM_MIN_CLAVE= 8;
	private static final String FORMAT_MAY = ".*[A-Z].*";
	private static final String ERROR_MESSAGE_MAYUSCULA = "La clave debe contener al menos una letra mayúscula";
	private static final String FORMAT_NUM =".*[0-9].*";
	private static final String ERROR_MESSAGE_NUM = "La clave debe contener al menos un número";
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
	        throw new IllegalArgumentException(MESSAGE_EMPTY_FIELD);
	    }
	    if (!email_U.matches(FORMAT_EMAIL)) {
	        throw new IllegalArgumentException(MESSAGE_INVALID_FORMAT_EMAIL);
	    }
	    this.emailUsuario = email_U;
	}

	
	//CLAVE
	public String getclave() {
		return this.clave;
	}
	
	public void setClave(String clave) {
	    if (clave == null || clave.trim().isEmpty()) {
	        throw new IllegalArgumentException(MESSAGE_EMPTY_FIELD);
	    }
	    if (clave.length() < NUM_MIN_CLAVE) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_MIN_CARACTER);
	    }
	    if (!clave.matches(FORMAT_MAY)) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_MAYUSCULA);
	    }
	    if (!clave.matches(FORMAT_NUM)) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_NUM);
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
	    return emailUsuario != null && emailUsuario.matches(FORMAT_EMAIL);
	}

	public boolean esClaveValida() {
	    return clave != null && clave.length() >= 8 &&
	           clave.matches(FORMAT_MAY) &&
	           clave.matches(FORMAT_NUM);
	}
	
}
