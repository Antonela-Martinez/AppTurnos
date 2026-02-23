package ar.com.am.servicios;

import java.util.List;

import ar.com.am.clases.Cliente;
import ar.com.am.clases.Usuario;

public interface UserService {
	
	public Usuario obtenerUsuario(Long id);

	public void guardarUsuario(Usuario u);
	
	//public boolean existsUser(String email);
	
	public List<Usuario> listAll();

	public Cliente getByDni(Long dni);
}
