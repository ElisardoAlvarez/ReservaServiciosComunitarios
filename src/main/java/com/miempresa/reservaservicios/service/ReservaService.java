package com.miempresa.reservaservicios.service;

import com.miempresa.reservaservicios.model.Reserva;
import com.miempresa.reservaservicios.model.Servicio;
import com.miempresa.reservaservicios.repository.ReservaRepository;
import com.miempresa.reservaservicios.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ServicioRepository servicioRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, ServicioRepository servicioRepository) {
        this.reservaRepository = reservaRepository;
        this.servicioRepository = servicioRepository;
    }

    public boolean crearReserva(Long servicioId, String username, LocalDateTime fechaHora) {
        Optional<Servicio> servicioOpt = servicioRepository.findById(servicioId);
        if (servicioOpt.isPresent()) {
            Servicio servicio = servicioOpt.get();
            List<Reserva> reservasExistentes = reservaRepository.findByServicioAndFechaHora(servicio, fechaHora);
            if (reservasExistentes.size() < servicio.getCapacidad()) {
                Reserva nuevaReserva = new Reserva();
                // Configurar y guardar la nueva reserva
                reservaRepository.save(nuevaReserva);
                return true;
            }
        }
        return false;
    }

    // Métodos adicionales para manejar reservas
}