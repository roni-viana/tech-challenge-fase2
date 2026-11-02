package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CriarUtilizadorUseCaseTest {

    @Mock
    private UtilizadorGateway utilizadorGateway;

    @InjectMocks
    private CriarUtilizadorUseCase criarUtilizadorUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarUtilizadorComSucesso() {
        Utilizador utilizador = new Utilizador(null, "João", "joao@email.com", 1L);
        Utilizador salvo = new Utilizador(1L, "João", "joao@email.com", 1L);
        when(utilizadorGateway.salvar(any(Utilizador.class))).thenReturn(salvo);

        Utilizador resultado = criarUtilizadorUseCase.executar(utilizador);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(utilizadorGateway, times(1)).salvar(any(Utilizador.class));
    }
}