package com.miempresa.reservaservicios.repository;

import com.miempresa.reservaservicios.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}

