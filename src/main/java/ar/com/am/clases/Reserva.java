package ar.com.am.clases;

import java.util.Date;

public class Reserva {
	private int id;
	private Cliente cliente;
	private Profesional profesional;
	private Servicio servicio;
	private Date fecha;
	private int hora;
	
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
