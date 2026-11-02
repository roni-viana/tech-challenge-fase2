package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;

import java.util.List;

public class ListarRestaurantesUseCase {

    private final RestauranteGateway restauranteGateway;

    public ListarRestaurantesUseCase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public List<Restaurante> executar() {
        return restauranteGateway.listarTodos();
    }
}