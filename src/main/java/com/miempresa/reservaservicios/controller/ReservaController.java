package com.miempresa.reservaservicios.controller;

import com.miempresa.reservaservicios.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/horarios-disponibles")
    public List<LocalTime> obtenerHorariosDisponibles() {
        return reservaService.generarHorariosDisponibles();
    }
}
