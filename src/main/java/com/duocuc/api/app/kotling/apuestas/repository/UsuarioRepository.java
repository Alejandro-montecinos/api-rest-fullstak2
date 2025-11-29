package com.duocuc.api.app.kotling.apuestas.repository;

import com.duocuc.api.app.kotling.apuestas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByCorreo(String correo);

}
