package com.postech.tech_challenge_fase2.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utilizador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilizadorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "id_tipo_usuario", nullable = false)
    private Long idTipoUsuario;
}