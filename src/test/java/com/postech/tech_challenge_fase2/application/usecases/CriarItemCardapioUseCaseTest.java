package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CriarItemCardapioUseCaseTest {

    @Mock
    private ItemCardapioGateway itemCardapioGateway;

    @InjectMocks
    private CriarItemCardapioUseCase criarItemCardapioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarItemCardapioComSucesso() {
        ItemCardapio item = new ItemCardapio(null, "Pizza", "Mussarela", new BigDecimal("40.0"), false, "foto.png", 1L);
        ItemCardapio salvo = new ItemCardapio(1L, "Pizza", "Mussarela", new BigDecimal("40.0"), false, "foto.png", 1L);
        when(itemCardapioGateway.salvar(any(ItemCardapio.class))).thenReturn(salvo);

        ItemCardapio resultado = criarItemCardapioUseCase.executar(item);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(itemCardapioGateway, times(1)).salvar(any(ItemCardapio.class));
    }
}