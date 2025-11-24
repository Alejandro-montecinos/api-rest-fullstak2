package com.duocuc.api.app.kotling.apuestas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true,updatable = true)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false,length = 3)
    private Integer edad;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String moneda;

    @Column(nullable = false)
    private Double monto;



}
