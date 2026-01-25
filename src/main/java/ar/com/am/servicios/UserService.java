package ar.com.am.servicios;

import ar.com.am.clases.Usuario;

public interface UserService {
	
	public Usuario obtener(Long id);

	public void guardarUsuario(Usuario u);
}
