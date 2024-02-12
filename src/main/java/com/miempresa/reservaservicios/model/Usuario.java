package com.miempresa.reservaservicios.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private String username;
    private String password;
    private String nombre;
    private String apellido;

    // Getters y setters
}

