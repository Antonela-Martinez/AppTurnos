package ar.com.am.clases;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "RESERVAS")
public class Reserva extends Keyed {
	public static final String ERROR_MESSAGE_EMPTY_CLIENTE = "La Reserva debe tener un dni Cliente";
	public static final String ERROR_MESSAGE_EMPTY_PROF = "La reserva debe incluir un profesional";
	public static final String ERROR_MESSAGE_EMPTY_SERVICIO = "La reserva debe incluir un servicio";
	public static final String ERROR_MESSAGE_EMPTY_FECHA = "La fecha de la reserva no puede estar vacia";
	public static final String ERROR_MESSAGE_PASS_FECHA = "La fecha de la reserva no puede ser en el pasado";
	public static final String ERROR_HORA_INVALIDA = "La hora debe estar entre 0 y 23";
	private static final int HORA_MAX = 23;
	private static final int HORA_MIN = 0;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "ID")
	private Cliente cliente;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prof_id", referencedColumnName = "ID")
	private Profesional profesional;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicio_id", referencedColumnName = "ID")
	private Servicio servicio;
	@Column(name = "fecha")
	private LocalDate fecha;
	@Column(name = "hora")
	private int hora;
	
	//Just for Hibernate
	Reserva(){
		
	}
	
	public Reserva(Cliente cliente, Profesional prof, Servicio servicio, LocalDate fecha, int hora) {
		setCliente(cliente);
		setProfesional(prof);
		setServicio(servicio);
		setFecha(fecha);
		setHora(hora);
	}
	
	//CLIENTE
	public void setCliente(Cliente cliente) {
		if (cliente == null) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_CLIENTE);
	    }

		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	//PROFESIONAL
	public void setProfesional(Profesional prof) {
		if (prof == null) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_PROF);
	    }

		this.profesional = prof;
	}
	
	public Profesional getProfesional() {
		return this.profesional;
	}
	
	//SERVICIO
	public void setServicio(Servicio servicio) {
		if (servicio == null) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_SERVICIO);
	    }
		this.servicio = servicio;
	}
	
	public Servicio getServicio() {
		return this.servicio;
	}
	
	//FECHA
	public void setFecha(LocalDate fecha) {
	    if (fecha == null) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_FECHA);
	    }
	    if (fecha.isBefore(LocalDate.now())) {
	        throw new IllegalArgumentException(ERROR_MESSAGE_PASS_FECHA);
	    }
	    this.fecha = fecha;
	}

	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	//HORA
	public void setHora(int hora) {
	    if (hora < HORA_MIN|| hora > HORA_MAX) {
	        throw new IllegalArgumentException(ERROR_HORA_INVALIDA);
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
	           hora >= 0 && hora <= HORA_MAX;
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
