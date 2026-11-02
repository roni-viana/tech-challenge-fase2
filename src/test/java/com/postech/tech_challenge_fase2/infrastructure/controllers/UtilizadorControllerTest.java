package com.postech.tech_challenge_fase2.infrastructure.controllers;

import com.postech.tech_challenge_fase2.application.usecases.*;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UtilizadorControllerTest {

    @Mock private CriarUtilizadorUseCase criarUtilizadorUseCase;
    @Mock private ListarUtilizadoresUseCase listarUtilizadoresUseCase;
    @Mock private BuscarUtilizadorPorIdUseCase buscarUtilizadorPorIdUseCase;
    @Mock private AtualizarUtilizadorUseCase atualizarUtilizadorUseCase;
    @Mock private DeletarUtilizadorUseCase deletarUtilizadorUseCase;

    @InjectMocks
    private UtilizadorController utilizadorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarUtilizadorRetornandoStatus201() {
        Utilizador utilizador = new Utilizador(1L, "Maria", "maria@email.com", 2L);
        when(criarUtilizadorUseCase.executar(any(Utilizador.class))).thenReturn(utilizador);

        ResponseEntity<Utilizador> response = utilizadorController.criar(utilizador);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Maria", response.getBody().getNome());
    }
}