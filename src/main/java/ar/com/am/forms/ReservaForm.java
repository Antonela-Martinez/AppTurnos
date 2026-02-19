package ar.com.am.forms;

import java.time.LocalDate;


public class ReservaForm {

	private Long dni;
	private String nombre;
	private String apellido;
	private long telefono;
	private String email;
	private Long servicioId;
	private Long profesionalId;
	private LocalDate fecha;
	private int hora;
	
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getServicioId() {
		return servicioId;
	}
	public void setServicio(Long servicioId) {
		this.servicioId = servicioId;
	}
	public Long getProfesionalId() {
		return profesionalId;
	}
	public void setProfesionalId(Long profesional) {
		this.profesionalId = profesional;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	
	
}
