package ar.com.am.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.am.clases.Profesional;
import ar.com.am.repositorios.ProfesionalRepository;


@Service
public class ProfesionalServiceImp extends UserServiceImp<Profesional,ProfesionalRepository> implements ProfesionalService {
	@Autowired
	private ProfesionalRepository repository;





}
