package com.miempresa.reservaservicios.service;

import com.miempresa.reservaservicios.repository.UsuariosRepository;
import com.miempresa.reservaservicios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuariosRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuariosRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para crear un nuevo usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método para obtener un usuario por ID
    public Usuario obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Método para actualizar un usuario
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}