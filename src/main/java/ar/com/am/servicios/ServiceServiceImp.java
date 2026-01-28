package ar.com.am.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.am.clases.Servicio;
import ar.com.am.repositorios.ServiceRepository;

@Service
public class ServiceServiceImp implements ServiceService {
	
	@Autowired
	private ServiceRepository repositoryS;
	
	public void guardarServicio (Servicio s) {
		this.repositoryS.save(s);
	}

	@Override
	public Servicio obtenerServicio(Long id) {
		Optional<Servicio> service = this.repositoryS.findById(id);
		return service.get();
	
	}
}
