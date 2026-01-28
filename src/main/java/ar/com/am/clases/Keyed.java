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
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//estrategia por la cual se va a generar el id, en este caso es autoincremental, lo hace la base de dato
	private Long id;
	
	public Long getId() {
        return id;
    }

    // equals basado en id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                // mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) return false; // distinto tipo
        Keyed keyed = (Keyed) o;
        return id != null && id.equals(keyed.id);  // compara por id
    }

    // hashCode coherente con equals
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}



