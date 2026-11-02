package com.postech.tech_challenge_fase2.infrastructure.controllers;

import com.postech.tech_challenge_fase2.application.usecases.*;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;
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

class RestauranteControllerTest {

    @Mock
    private CriarRestauranteUseCase criarRestauranteUseCase;
    
    @Mock
    private ListarRestaurantesUseCase listarRestaurantesUseCase;
    
    @Mock
    private BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;
    
    @Mock
    private AtualizarRestauranteUseCase atualizarRestauranteUseCase;
    
    @Mock
    private DeletarRestauranteUseCase deletarRestauranteUseCase;

    @InjectMocks
    private RestauranteController restauranteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarRestauranteRetornandoStatus201() {
        Restaurante restaurante = new Restaurante(1L, "Restaurante Controller", "Rua C", "Brasileira", "10-22", 1L);
        when(criarRestauranteUseCase.executar(any(Restaurante.class))).thenReturn(restaurante);

        ResponseEntity<Restaurante> response = restauranteController.criar(restaurante);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Restaurante Controller", response.getBody().getNome());
    }

    @Test
    void deveBuscarRestaurantePorIdRetornandoStatus200() {
        Restaurante restaurante = new Restaurante(1L, "Restaurante Controller", "Rua C", "Brasileira", "10-22", 1L);
        when(buscarRestaurantePorIdUseCase.executar(1L)).thenReturn(restaurante);

        ResponseEntity<Restaurante> response = restauranteController.buscarPorId(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Restaurante Controller", response.getBody().getNome());
    }
}