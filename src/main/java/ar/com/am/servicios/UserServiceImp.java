package ar.com.am.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.am.clases.Usuario;
import ar.com.am.repositorios.UserRepository;

//Cuando encuentre este anotation, Spring va a crear una instancia de la clase UserService, y la va ainyectar a traves de la inyeccion de dependencias
//va a crear un objeto de esta clase y lo va a inyectar al atributo correspondiente
//Si usamos una clase concreta lo estamos atando a implementaciones determinadas, por eso hay que usar interfaz
@Service
public class UserServiceImp implements UserService{
	//con este anoteyon Spring al crear un objeto UserService, va a detectar que tiene que inicializar este atributo (repository)
	//va a buscar una implementacion de la interfaz UserRepository para poder inyectarlo en el atributo repository
	//como no hay una clase propia de esta interfaz va a crear una por defecto siempre y cuando implemente la interfaz UserRepository??
	@Autowired
	private UserRepository repository;
	
	//metodos de negocio
	public void guardarUsuario(Usuario u) {
		//aca generamos un nivel de abstraccion entre el servicio y el repositorio
		this.repository.save(u);
	}
}
