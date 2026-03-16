package ar.com.am.servicios;

import java.util.List;

import ar.com.am.clases.Usuario;

public interface UserService<T extends Usuario> {
	
	//public Usuario obtenerUsuario(Long id);
	public T obtenerUsuario(Long id);

	//public void guardarUsuario(Usuario u);
	public void guardar(T usuario);
	
	//public boolean existsUser(String email);
	
	//public List<Usuario> listAll();
	public List<T> listAll();

	//public Cliente getByDni(Long dni);
	public T getByDni(Long dni);
	
	public T load(Long id);
}
