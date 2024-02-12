package com.miempresa.reservaservicios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @GetMapping("/reservas")
    public String mostrarReservas() {
        return "reservas";
    }

    @GetMapping("/crear-reserva")
    public String mostrarCrearReserva() {
        return "crear-reserva";
    }

    @GetMapping("/mis-reservas")
    public String mostrarMisReservas() {
        return "mis-reservas";
    }
}
