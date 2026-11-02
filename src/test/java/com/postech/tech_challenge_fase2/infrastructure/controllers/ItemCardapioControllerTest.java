package com.postech.tech_challenge_fase2.infrastructure.controllers;

import com.postech.tech_challenge_fase2.application.usecases.*;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ItemCardapioControllerTest {

    @Mock private CriarItemCardapioUseCase criarItemCardapioUseCase;
    @Mock private ListarItensCardapioUseCase listarItensCardapioUseCase;
    @Mock private BuscarItemCardapioPorIdUseCase buscarItemCardapioPorIdUseCase;
    @Mock private AtualizarItemCardapioUseCase atualizarItemCardapioUseCase;
    @Mock private DeletarItemCardapioUseCase deletarItemCardapioUseCase;

    @InjectMocks
    private ItemCardapioController itemCardapioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarItemCardapioRetornandoStatus201() {
        ItemCardapio item = new ItemCardapio(1L, "Hamburguer", "Artesanal", new BigDecimal("35.0"), false, "foto.png", 1L);
        when(criarItemCardapioUseCase.executar(any(ItemCardapio.class))).thenReturn(item);

        ResponseEntity<ItemCardapio> response = itemCardapioController.criar(item);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Hamburguer", response.getBody().getNome());
    }
}