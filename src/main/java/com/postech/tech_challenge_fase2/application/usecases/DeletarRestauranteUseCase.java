package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;

public class DeletarRestauranteUseCase {

    private final RestauranteGateway restauranteGateway;

    public DeletarRestauranteUseCase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public void executar(Long id) {
        restauranteGateway.deletar(id);
    }
}