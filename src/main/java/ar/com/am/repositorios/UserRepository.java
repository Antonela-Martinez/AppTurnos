package ar.com.am.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.am.clases.Usuario;

public interface UserRepository<T extends Usuario> extends JpaRepository<T, Long>{
	
	//public List<Usuario> findByEmail(String email);
	
	//public Usuario findByDni(Long dni);
	public List<T> findByDni(Long dni);
	
	public List<T> findByNombre(String nombre);

	//public Profesional loadById(Long id);
	//public T loadById(Long id);
	
	//public Optional findById(Long id);


}
