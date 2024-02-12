package com.miempresa.reservaservicios.service;

import com.miempresa.reservaservicios.repository.ReservaRepository;
import com.miempresa.reservaservicios.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<LocalTime> generarHorariosDisponibles() {
        List<LocalTime> horariosDisponibles = new ArrayList<>();
        LocalTime inicio = LocalTime.of(8, 0); // 8:00 am
        LocalTime fin = LocalTime.of(22, 0); // 10:00 pm

        for (LocalTime hora = inicio; hora.isBefore(fin); hora = hora.plusHours(1)) {
            horariosDisponibles.add(hora);
        }

        return horariosDisponibles;
    }

    public Reserva crearReserva(Reserva reserva) {
        LocalTime horaReserva = reserva.getHora();
        List<LocalTime> horariosDisponibles = generarHorariosDisponibles();

        if (!horariosDisponibles.contains(horaReserva)) {
            throw new IllegalArgumentException("La hora de la reserva no está dentro de los horarios disponibles.");
        }

        return reservaRepository.save(reserva);
    }

    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva actualizarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}