package ar.com.am.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.am.clases.Reserva;

@Repository
public interface BookingRepository extends JpaRepository<Reserva, Long> {

}
