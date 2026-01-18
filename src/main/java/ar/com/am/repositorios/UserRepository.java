package ar.com.am.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.am.clases.Usuario;

//para que Spring lo considere un repositorio con JpaRepository es a traves de anoteyon @Repository
//<1:tipo de dato de la entidad que se va a estar persistiendo(son los objetos de la clase que se van a estar guardando en la BD)
//2:El tipo nde dato que representa el ID de esta entidad>
//Extiende de JpaRepository, para que cuando spring encuentre esta interfaz(UserRepository)sepa que tiene que ser creada como un repositorio 
//no se pueden crear objetos desde una interfaz, por eso extiende de JpaRepository porque tiene las librerias necesarias para crear una instancia concreta para crear un objeto
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

}
