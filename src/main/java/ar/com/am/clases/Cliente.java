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
	
	
	
	public boolean tieneEmail(String email) {
	return this.email.equals(email);
}
	
	private void setEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("El mail no debe estar vacio");
		}
		
		this.email = email;
	}
	
	 public String toString() {
	    return "Cliente: "+getDni()+ "| Nombre: "+ getNombre();
	 }
}
