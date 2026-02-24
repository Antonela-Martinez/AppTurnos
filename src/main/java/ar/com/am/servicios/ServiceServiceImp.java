package ar.com.am.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.am.clases.Servicio;
import ar.com.am.dtos.ServicioDTO;
import ar.com.am.repositorios.ServiceRepository;

@Service
public class ServiceServiceImp implements ServiceService {
	
	@Autowired
	private ServiceRepository repository;
	
	private ModelMapper mapper = new ModelMapper();
	
	public void guardarServicio (Servicio s) {
		this.repository.save(s);
	}

	@Override
	public Servicio obtenerServicio(Long id) {
		Optional<Servicio> service = this.repository.findById(id);
		if (service.isPresent()) {
	        return service.get();
	    } else {
	        System.out.println("Servicio no encontrado con id: " + id);
	        return null;
	    }
	
	}

	@Override
	public List<ServicioDTO> listAll() {
		List<Servicio> servicio = this.repository.findAll();
		List<ServicioDTO> serviciosDTO = new ArrayList<ServicioDTO>();
		
		for(Servicio serv : servicio) {
			
			serviciosDTO.add(mapper.map(serv, ServicioDTO.class));
		}
		
		return serviciosDTO;
	}


}
