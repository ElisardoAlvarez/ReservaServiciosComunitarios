package com.miempresa.reservaservicios;

import com.miempresa.reservaservicios.model.Reserva;
import com.miempresa.reservaservicios.model.Usuario;
import com.miempresa.reservaservicios.service.ReservaService;
import com.miempresa.reservaservicios.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReservaServiciosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservaServiciosApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UsuarioService usuarioService, ReservaService reservaService) {
        return (args) -> {
            // Crear usuarios de prueba
            Usuario usuario1 = new Usuario();
            usuario1.setNombre("Usuario de prueba 1");
            usuarioService.crearUsuario(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setNombre("Usuario de prueba 2");
            usuarioService.crearUsuario(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setNombre("Usuario de prueba 3");
            usuarioService.crearUsuario(usuario3);

            // Crear reservas de prueba
            Reserva reserva1 = new Reserva();
            reserva1.setUsuario(usuario1);
            reservaService.crearReserva(reserva1);

            Reserva reserva2 = new Reserva();
            reserva2.setUsuario(usuario2);
            reservaService.crearReserva(reserva2);

            Reserva reserva3 = new Reserva();
            reserva3.setUsuario(usuario3);
            reservaService.crearReserva(reserva3);

            Reserva reserva4 = new Reserva();
            reserva4.setUsuario(usuario1);
            reservaService.crearReserva(reserva4);
        };
    }
}