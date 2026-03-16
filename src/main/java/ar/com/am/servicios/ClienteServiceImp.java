package ar.com.am.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.am.clases.Cliente;
import ar.com.am.repositorios.ClienteRepository;

@Service
public class ClienteServiceImp extends UserServiceImp<Cliente,ClienteRepository> implements ClienteService{
	@Autowired
	private ClienteRepository repository;

}
