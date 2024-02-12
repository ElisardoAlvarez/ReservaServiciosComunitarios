package com.miempresa.reservaservicios.repository;

import com.miempresa.reservaservicios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, String> {
}

