package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;

public class CriarRestauranteUseCase {

    private final RestauranteGateway restauranteGateway;

    public CriarRestauranteUseCase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Restaurante executar(Restaurante restaurante) {
        return restauranteGateway.salvar(restaurante);
    }
}