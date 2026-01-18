package ar.com.am.servicios;

import ar.com.am.clases.Servicio;
import ar.com.am.repositorios.ServiceRepository;

public class ServiceServiceImp implements ServiceService {

	private ServiceRepository repositoryS;
	
	public void guardarServicio (Servicio s) {
		this.repositoryS.save(s);
	}
}
