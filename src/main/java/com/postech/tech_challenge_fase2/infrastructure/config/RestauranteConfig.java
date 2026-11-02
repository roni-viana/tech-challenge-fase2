package com.postech.tech_challenge_fase2.infrastructure.config;

import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteConfig {

    @Bean
    public CriarRestauranteUseCase criarRestauranteUseCase(RestauranteGateway restauranteGateway) {
        return new CriarRestauranteUseCase(restauranteGateway);
    }

    @Bean
    public ListarRestaurantesUseCase listarRestaurantesUseCase(RestauranteGateway restauranteGateway) {
        return new ListarRestaurantesUseCase(restauranteGateway);
    }

    @Bean
    public BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase(RestauranteGateway restauranteGateway) {
        return new BuscarRestaurantePorIdUseCase(restauranteGateway);
    }

    @Bean
    public AtualizarRestauranteUseCase atualizarRestauranteUseCase(RestauranteGateway restauranteGateway) {
        return new AtualizarRestauranteUseCase(restauranteGateway);
    }

    @Bean
    public DeletarRestauranteUseCase deletarRestauranteUseCase(RestauranteGateway restauranteGateway) {
        return new DeletarRestauranteUseCase(restauranteGateway);
    }
}