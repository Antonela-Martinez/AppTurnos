package ar.com.am.servicios;

import java.util.List;

public interface UserService<T> {
	
	//public Usuario obtenerUsuario(Long id);
	public T obtenerUsuario(Long id);

	//public void guardarUsuario(Usuario u);
	public void guardarUsuario(T usuario);
	
	//public boolean existsUser(String email);
	
	//public List<Usuario> listAll();
	public List<T> listAll();

	//public Cliente getByDni(Long dni);
	public T getByDni(Long dni);
}
