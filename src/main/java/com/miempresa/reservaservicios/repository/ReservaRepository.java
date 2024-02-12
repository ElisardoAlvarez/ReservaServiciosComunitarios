package com.miempresa.reservaservicios.repository;



import com.miempresa.reservaservicios.model.Reserva;
import com.miempresa.reservaservicios.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByServicioAndFechaHora(Servicio servicio, LocalDateTime fechaHora);
}

