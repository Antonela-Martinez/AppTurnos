package ar.com.am.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.am.clases.Servicio;

@Repository
public interface ServiceRepository extends JpaRepository<Servicio, Long> {

}
