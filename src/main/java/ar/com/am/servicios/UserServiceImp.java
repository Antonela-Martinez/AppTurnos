package ar.com.am.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.am.clases.Usuario;
import ar.com.am.repositorios.UserRepository;


public abstract class UserServiceImp <T extends Usuario, R extends UserRepository<T>> implements UserService<T>{
	@Autowired
	private R repository;
	
	
	public void guardar(T usuario) {
		this.repository.save(usuario);//aca generamos un nivel de abstraccion entre el servicio y el repositorio
	}

	@Override
	public T obtenerUsuario(Long id) {
	    Optional<T> user = this.repository.findById(id);
	    if (user.isPresent()) {
	        return user.get();
	    } else {
	        System.out.println("Usuario no encontrado con id: " + id);
	        return null;
	    }
	}

	@Override
	public  List<T> listAll() {
		return this.repository.findAll();
	}

	@Override
	public T getByDni(Long dni) {
		List<T> listatest = repository.findByDni(dni);
		if (listatest.isEmpty()) return null;
		if (listatest.size() > 1) throw new RuntimeException("Mas d eun usuario con este dni");
		
	    return listatest.get(0);
	}
	
	public T load(Long id) {
		Optional<T> option = this.repository.findById(id);
		if (option.isEmpty()) return null;
		
		return option.get();
		
	}



	

	/*@Override
	public boolean existsUser(String email) {
		boolean exists = false;
		
		if(email != null) {
			List<Usuario> usuarios = this.repository.findByEmail(email);
			exists = ! usuarios.isEmpty();
		}
		return exists;
	}*/
	
	//@Service: Cuando encuentre este anotation, Spring va a crear una instancia de la clase UserService, y la va ainyectar a
	//traves de la inyeccion de dependencias
	//va a crear un objeto de esta clase y lo va a inyectar al atributo correspondiente
	//Si usamos una clase concreta lo estamos atando a implementaciones determinadas, por eso hay que usar interfaz
	
	//con este anoteyon Spring al crear un objeto UserService, va a detectar que tiene que inicializar este atributo (repository)
	//va a buscar una implementacion de la interfaz UserRepository para poder inyectarlo en el atributo repository
	//como no hay una clase propia de esta interfaz va a crear una por defecto siempre y cuando implemente la interfaz UserRepository??
	//@Autowired
	//private R repository;
	
	
}
