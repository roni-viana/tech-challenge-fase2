package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;
import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuscarRestaurantePorIdUseCaseTest {

    @Mock
    private RestauranteGateway restauranteGateway;

    @InjectMocks
    private BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarRestauranteComSucesso() {
        // Arrange
        Restaurante restauranteMock = new Restaurante(1L, "Restaurante Teste", "Rua A", "Italiana", "10-22", 1L);
        when(restauranteGateway.buscarPorId(1L)).thenReturn(Optional.of(restauranteMock));

        // Act
        Restaurante resultado = buscarRestaurantePorIdUseCase.executar(1L);

        // Assert
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(restauranteGateway, times(1)).buscarPorId(1L);
    }

    @Test
    void deveLancarExcecaoQuandoRestauranteNaoExistir() {
        // Arrange
        when(restauranteGateway.buscarPorId(99L)).thenReturn(Optional.empty());

        // Act & Assert
        EntidadeNaoEncontradaException exception = assertThrows(EntidadeNaoEncontradaException.class, () -> {
            buscarRestaurantePorIdUseCase.executar(99L);
        });

        assertEquals("Restaurante não encontrado com o ID: 99", exception.getMessage());
        verify(restauranteGateway, times(1)).buscarPorId(99L);
    }
}