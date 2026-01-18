package ar.com.am.clases;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

//Forma de espesificarle a Hibernat que estos datos deben ser persistibles en la BD pero no se van a crear objetos de esta clase
//Con este anotyon estamos diciendo que esta clase actua como una super clase que actua como agrupamientop de atributos o comportamientos en comun de clases hijas
//tiene mapeos con columnas pero esta clase en si nop se mapea con ninguna tabla de la BD y quienes van a tener las tablas son las hijas
//Podemos empezar a agrupar a traves d ela herencia atributos y comportamientos en comunes y tambien persistir coliumnas en comunes en todos aquellos atributos que estan indicados por la clase padre
@MappedSuperclass
public abstract class Keyed {
	@Id 
	@Column(name = "ID")
	//estrategia por la cual se va a generar el id, en este caso es autoincremental, lo hace la base de dato
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
