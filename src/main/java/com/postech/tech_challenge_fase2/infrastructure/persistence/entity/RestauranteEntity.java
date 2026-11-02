package com.postech.tech_challenge_fase2.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(name = "tipo_cozinha", nullable = false)
    private String tipoCozinha;

    @Column(name = "horario_funcionamento", nullable = false)
    private String horarioFuncionamento;

    @Column(name = "id_dono", nullable = false)
    private Long idDono;
}