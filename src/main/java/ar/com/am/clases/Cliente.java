package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "CLIENTES")
public class Cliente extends Usuario {
	@Column (name = "email")
	private String email;
	
	public Cliente(Long dni) {
		super(dni);
	}
	
	
	//Setter Email
	public void setEmail(String email) {
	    if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
	        throw new IllegalArgumentException("Email inválido");
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

	//METODOS DE VALIDACION
    public boolean esEmailValido() {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
	
	 public String toString() {
	    return "Cliente: "+getDni()+ "| Nombre: "+ getNombre();
	 }
}
