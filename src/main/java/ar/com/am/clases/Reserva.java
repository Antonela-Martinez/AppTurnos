package ar.com.am.clases;

import java.util.Date;

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
	private Date fecha;
	@Column(name = "hora")
	private int hora;
	
	//Just for Hibernate
	Reserva(){
		
	}
	
	public Reserva(Cliente cliente, Profesional prof, Servicio servicio, Date fecha, int hora) {
		this.cliente = cliente;
		this.profesional = prof;
		this.servicio = servicio;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public void reservarTurno() {
		
	}
	
	

}
