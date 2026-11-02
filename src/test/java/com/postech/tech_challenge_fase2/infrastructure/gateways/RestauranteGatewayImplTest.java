package com.postech.tech_challenge_fase2.infrastructure.gateways;

import com.postech.tech_challenge_fase2.domain.entity.Restaurante;
import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.RestauranteEntity;
import com.postech.tech_challenge_fase2.infrastructure.persistence.repository.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestauranteGatewayImplTest {

    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private RestauranteGatewayImpl restauranteGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarRestauranteComSucesso() {
        Restaurante restauranteDomain = new Restaurante(null, "Gateway Teste", "Rua B", "Japonesa", "18-23", 2L);
        RestauranteEntity restauranteEntity = new RestauranteEntity(1L, "Gateway Teste", "Rua B", "Japonesa", "18-23", 2L);

        when(repository.save(any(RestauranteEntity.class))).thenReturn(restauranteEntity);

        Restaurante salvo = restauranteGateway.salvar(restauranteDomain);

        assertNotNull(salvo);
        assertEquals(1L, salvo.getId());
        assertEquals("Gateway Teste", salvo.getNome());
        verify(repository, times(1)).save(any(RestauranteEntity.class));
    }

    @Test
    void deveBuscarPorIdComSucesso() {
        RestauranteEntity restauranteEntity = new RestauranteEntity(1L, "Gateway Teste", "Rua B", "Japonesa", "18-23", 2L);
        when(repository.findById(1L)).thenReturn(Optional.of(restauranteEntity));

        Optional<Restaurante> resultado = restauranteGateway.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
        verify(repository, times(1)).findById(1L);
    }
}