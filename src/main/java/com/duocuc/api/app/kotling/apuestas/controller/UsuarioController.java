package com.duocuc.api.app.kotling.apuestas.controller;


import com.duocuc.api.app.kotling.apuestas.model.UsuarioModel;
import com.duocuc.api.app.kotling.apuestas.service.UsuarioService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") // vite usa otro puerto
@RestController
@RequestMapping("/api/pokemon/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> getUsuarios(){
        return usuarioService.obtenerUsuario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> getUsuarioId(@PathVariable Integer id) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(u -> ResponseEntity.ok(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> PostUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel nuevo = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> PutUsuario(@PathVariable Integer id, @RequestBody UsuarioModel usuario) {
        return usuarioService.obtenerUsuarioPorId(id)
                .map(c -> {
                    usuario.setId(id);
                    UsuarioModel actualizado = usuarioService.editarUsuario(usuario);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteUsuario(@PathVariable Integer id) {
        return usuarioService.eliminarUsuario(id)
                .map(u -> ResponseEntity.noContent().<Void>build())
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioModel> login(@RequestBody LoginRequest request) {
        return usuarioService.login(request.getCorreo(), request.getContrasenia())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @Data
    public static class LoginRequest {
        private String correo;
        private String contrasenia;
    }




}
