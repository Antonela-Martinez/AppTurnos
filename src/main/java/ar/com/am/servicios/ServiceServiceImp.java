package ar.com.am.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.am.clases.Servicio;
import ar.com.am.repositorios.ServiceRepository;

@Service
public class ServiceServiceImp implements ServiceService {
	
	@Autowired
	private ServiceRepository repository;
	
	public void guardarServicio (Servicio s) {
		this.repository.save(s);
	}

	@Override
	public Servicio obtenerServicio(Long id) {
		Optional<Servicio> service = this.repository.findById(id);
		return service.get();
	
	}

	@Override
	public List<Servicio> listAll() {
		return this.repository.findAll();
	}


}
