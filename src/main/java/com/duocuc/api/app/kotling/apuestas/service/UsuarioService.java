package com.duocuc.api.app.kotling.apuestas.service;

import com.duocuc.api.app.kotling.apuestas.model.UsuarioModel;
import com.duocuc.api.app.kotling.apuestas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioModel> obtenerUsuario() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel crearUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel editarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public Optional<UsuarioModel> obtenerUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> eliminarUsuario(Integer id) {
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
        }

        return usuario;
    }

    public Optional<UsuarioModel> login(String correo, String contrasenia) {
        return usuarioRepository.findByCorreo(correo)
                .filter(u -> u.getContrasenia().equals(contrasenia));
    }



}
