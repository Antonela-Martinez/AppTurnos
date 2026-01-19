package ar.com.am.clases;

import java.time.LocalDate;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "RESERVAS")
public class Reserva extends Keyed {
	@Column(name = "cliente_id")
	private Cliente cliente;
	@Column(name = "prof_id")
	//mas que nada cuando tenes una tabla intermedia, la relacion muchos a muchos
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "prof_id", referencedColumnName = "ID")
	private Profesional profesional;
	@Column(name = "servicio_id")
	private Servicio servicio;
	@Column(name = "fecha")
	private LocalDate fecha;
	@Column(name = "hora")
	private int hora;
	
	//Just for Hibernate
	Reserva(){
		
	}
	
	public Reserva(Cliente cliente, Profesional prof, Servicio servicio, LocalDate fecha, int hora) {
		this.cliente = cliente;
		this.profesional = prof;
		this.servicio = servicio;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	//CLIENTE
	public void setCliente(Cliente cliente) {
		if (cliente == null) {
	        throw new IllegalArgumentException("La reserva debe incluir un servicio");
	    }

		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	//PROFESIONAL
	public void setProfesional(Profesional prof) {
		if (prof == null) {
	        throw new IllegalArgumentException("La reserva debe incluir un servicio");
	    }

		this.profesional = prof;
	}
	
	public Profesional getProfesional() {
		return this.profesional;
	}
	
	//SERVICIO
	public void setServicio(Servicio servicio) {
		if (servicio == null) {
	        throw new IllegalArgumentException("La reserva debe incluir un servicio");
	    }
		this.servicio = servicio;
	}
	
	public Servicio getServicio() {
		return this.servicio;
	}
	
	//FECHA
	public void setFecha(LocalDate fecha) {
	    if (fecha == null) {
	        throw new IllegalArgumentException("La fecha de la reserva no puede ser nula");
	    }
	    if (fecha.isBefore(LocalDate.now())) {
	        throw new IllegalArgumentException("La fecha de la reserva no puede ser en el pasado");
	    }
	    this.fecha = fecha;
	}

	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	//HORA
	public void setHora(int hora) {
	    if (hora < 0 || hora > 23) {
	        throw new IllegalArgumentException("La hora debe estar entre 0 y 23");
	    }
	    this.hora = hora;
	}
	
	public int getHora() {
		return this.hora;
	}
	
	//METODOS DE VALIDACION 
	public boolean esReservaValida() {
	    return cliente != null &&
	           profesional != null &&
	           servicio != null &&
	           fecha != null &&
	           !fecha.isBefore(LocalDate.now()) &&
	           hora >= 0 && hora <= 23;
	}
	
	//estaActiva() → devuelve true si la fecha de la reserva es futura.
	public boolean estaActiva() {
	    if (fecha == null) {
	        return false; 
	    }
	    LocalDate hoy = LocalDate.now();//fecha de hoy
	    return fecha.isAfter(hoy); // true si la fecha de la reserva es futura
	}

	

	//esParaHoy() → devuelve true si la fecha de la reserva coincide con la fecha actual (día/mes/año).
	public boolean esParaHoy() {
	    if (fecha == null) {
	        return false;
	    }
	    LocalDate hoy = LocalDate.now(); // obtiene la fecha actual del sistema
	    return fecha.equals(hoy);        // compara directamente
	}

	
	public void reservarTurno() {
		
	}
	
	

}
