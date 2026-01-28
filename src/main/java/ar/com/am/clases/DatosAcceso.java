package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table (name = "DATOS_ACCESO")
public class DatosAcceso extends Keyed{
	public static final String MSG_EMPTY_EMAIL = "El email no puede estar vacío";
	public static final String MSG_INVALID_FORMAT_EMAIL = "Formato de email inválido";
	public static final String FORMAT_EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	public static final String ERROR_MSG_MIN_CARACTER = "La clave debe tener al menos 8 caracteres";
	public static final String ERROR_MSG_MAX_CARACTER = "La clave no debe superar los 25 caracteres";
	public static final int NUM_MIN_CLAVE= 8;
	public static final int NUM_MAX_CLAVE= 25;
	private static final String FORMAT_MAY = ".*[A-Z].*";
	public static final String ERROR_MSG_SIN_MAYUSCULA = "La clave debe contener al menos una letra mayúscula";
	private static final String FORMAT_NUM =".*[0-9].*";
	public static final String ERROR_MSG_SIN_NUM = "La clave debe contener al menos un número";
	
	@Column(name = "email_us")
	private String emailUsuario;
	@Column(name = "clave")
	private String clave;
	@Column(name = "estado")
	private boolean estado;
	//@Enumerated(EnumType.STRING)
	//private EstadoAcceso estado;//enum para definir estados, activo, inactivo, autorizado, pendiente 
	
	DatosAcceso(){
		
	}
	
	public DatosAcceso(String us, String contraseña) {
		setEmailUsr(us);;
		setClave(contraseña);
	}
	
	//email usuario
	public String getEmailUsr() {
		return this.emailUsuario;
	}
	
	public void setEmailUsr(String email_U) {
	    if (email_U == null || email_U.trim().isEmpty()) {
	        throw new IllegalArgumentException(MSG_EMPTY_EMAIL);
	    }
	    if (!email_U.matches(FORMAT_EMAIL)) {
	        throw new IllegalArgumentException(MSG_INVALID_FORMAT_EMAIL);
	    }
	    this.emailUsuario = email_U;
	}

	
	//CLAVE
	public String getclave() {
		return this.clave;
	}
	
	public void setClave(String clave) {
	    if (clave == null || clave.trim().isEmpty()) {
	        throw new IllegalArgumentException(MSG_EMPTY_EMAIL);
	    }
	    if (clave.length() < NUM_MIN_CLAVE) {
	        throw new IllegalArgumentException(ERROR_MSG_MIN_CARACTER);
	    }
	    if (clave.length() > NUM_MAX_CLAVE) {
	        throw new IllegalArgumentException(ERROR_MSG_MAX_CARACTER);
	    }
	    if (!clave.matches(FORMAT_MAY)) {
	        throw new IllegalArgumentException(ERROR_MSG_SIN_MAYUSCULA);
	    }
	    if (!clave.matches(FORMAT_NUM)) {
	        throw new IllegalArgumentException(ERROR_MSG_SIN_NUM);
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
