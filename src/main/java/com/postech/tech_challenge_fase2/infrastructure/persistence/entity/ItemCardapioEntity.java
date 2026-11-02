package com.postech.tech_challenge_fase2.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "item_cardapio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCardapioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name = "apenas_local", nullable = false)
    private boolean apenasLocal;

    @Column(name = "caminho_foto")
    private String caminhoFoto;

    @Column(name = "id_restaurante", nullable = false)
    private Long idRestaurante;
}