package ar.com.am.servicios;

import ar.com.am.clases.Usuario;

public interface UserService {
	
	public Usuario obtenerUsuario(Long id);

	public void guardarUsuario(Usuario u);
	
	//public boolean existsUser(String email);
}
