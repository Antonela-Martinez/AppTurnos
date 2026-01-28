package ar.com.am.servicios;

import ar.com.am.clases.Servicio;


public interface ServiceService {
	
	public Servicio obtenerServicio(Long id);

	public void guardarServicio(Servicio s);


}
