package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table (name = "CLIENTES")
public class Cliente extends Usuario {
	public static final String  ERROR_MSG_EMAIL_INVALIDO = "Email inválido";
	
	@Column (name = "email")
	private String email;
	
	public Cliente(Long dni) {
		super(dni);
	}
	
	
	//Setter Email
	public void setEmail(String email) {
	    if (email == null || !email.matches(DatosAcceso.FORMAT_EMAIL)) {
	        throw new IllegalArgumentException(ERROR_MSG_EMAIL_INVALIDO);
	    }
	    if (!email.matches(DatosAcceso.FORMAT_EMAIL)) {
	        throw new IllegalArgumentException(DatosAcceso.MSG_INVALID_FORMAT_EMAIL);
	    }
	    this.email = email;
	}
	
	//getter Email
	public String getEmail() {
		return this.email;
	}

	public boolean emailExist(String email) {
	return this.email.equals(email);
	}

    
	public String toString() {
	    return "Cliente: "+getDni()+ "| Nombre: "+ getNombre();
	}
}
