package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;
import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;

public class BuscarRestaurantePorIdUseCase {

    private final RestauranteGateway restauranteGateway;

    public BuscarRestaurantePorIdUseCase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Restaurante executar(Long id) {
        // Se o restaurante não existir, lançamos uma exceção genérica (depois podemos criar exceções personalizadas)
        // Lembra-te de importar a classe: import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;

return restauranteGateway.buscarPorId(id)
    .orElseThrow(() -> new EntidadeNaoEncontradaException("Restaurante não encontrado com o ID: " + id));
    }
}