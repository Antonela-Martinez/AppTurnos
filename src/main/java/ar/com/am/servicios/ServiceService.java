package ar.com.am.servicios;

import java.util.List;

import ar.com.am.clases.Servicio;
import ar.com.am.dtos.ServicioDTO;


public interface ServiceService {
	
	public Servicio obtenerServicio(Long id);

	public void guardarServicio(Servicio s);
	
	public List<ServicioDTO> listAll();
	

}
