package com.postech.tech_challenge_fase2.infrastructure.config;

import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;
import com.postech.tech_challenge_fase2.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemCardapioConfig {

    @Bean
    public CriarItemCardapioUseCase criarItemCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        return new CriarItemCardapioUseCase(itemCardapioGateway);
    }

    @Bean
    public ListarItensCardapioUseCase listarItensCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        return new ListarItensCardapioUseCase(itemCardapioGateway);
    }

    @Bean
    public BuscarItemCardapioPorIdUseCase buscarItemCardapioPorIdUseCase(ItemCardapioGateway itemCardapioGateway) {
        return new BuscarItemCardapioPorIdUseCase(itemCardapioGateway);
    }

    @Bean
    public AtualizarItemCardapioUseCase atualizarItemCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        return new AtualizarItemCardapioUseCase(itemCardapioGateway);
    }

    @Bean
    public DeletarItemCardapioUseCase deletarItemCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        return new DeletarItemCardapioUseCase(itemCardapioGateway);
    }
}