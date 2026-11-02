package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CriarRestauranteUseCaseTest {

    @Mock
    private RestauranteGateway restauranteGateway;

    @InjectMocks
    private CriarRestauranteUseCase criarRestauranteUseCase;

    @BeforeEach
    void setUp() {
        // Inicializa os mocks do Mockito antes de cada teste
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarRestauranteComSucesso() {
        // Arrange (Preparar os dados)
        Restaurante restauranteParaCriar = new Restaurante(null, "Restaurante Teste", "Rua A", "Italiana", "10-22", 1L);
        Restaurante restauranteCriado = new Restaurante(1L, "Restaurante Teste", "Rua A", "Italiana", "10-22", 1L);

        // Quando o gateway for chamado, devolvemos o restaurante simulado (Mock)
        when(restauranteGateway.salvar(any(Restaurante.class))).thenReturn(restauranteCriado);

        // Act (Executar o método)
        Restaurante resultado = criarRestauranteUseCase.executar(restauranteParaCriar);

        // Assert (Verificar se o resultado é o esperado)
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Restaurante Teste", resultado.getNome());
        
        // Verifica se o gateway foi chamado exatamente uma vez
        verify(restauranteGateway, times(1)).salvar(any(Restaurante.class));
    }
}