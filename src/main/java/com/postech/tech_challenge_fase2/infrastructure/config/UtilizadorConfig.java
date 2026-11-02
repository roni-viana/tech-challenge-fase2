package com.postech.tech_challenge_fase2.infrastructure.config;

import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;
import com.postech.tech_challenge_fase2.application.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilizadorConfig {

    @Bean
    public CriarUtilizadorUseCase criarUtilizadorUseCase(UtilizadorGateway utilizadorGateway) {
        return new CriarUtilizadorUseCase(utilizadorGateway);
    }

    @Bean
    public ListarUtilizadoresUseCase listarUtilizadoresUseCase(UtilizadorGateway utilizadorGateway) {
        return new ListarUtilizadoresUseCase(utilizadorGateway);
    }

    @Bean
    public BuscarUtilizadorPorIdUseCase buscarUtilizadorPorIdUseCase(UtilizadorGateway utilizadorGateway) {
        return new BuscarUtilizadorPorIdUseCase(utilizadorGateway);
    }

    @Bean
    public AtualizarUtilizadorUseCase atualizarUtilizadorUseCase(UtilizadorGateway utilizadorGateway) {
        return new AtualizarUtilizadorUseCase(utilizadorGateway);
    }

    @Bean
    public DeletarUtilizadorUseCase deletarUtilizadorUseCase(UtilizadorGateway utilizadorGateway) {
        return new DeletarUtilizadorUseCase(utilizadorGateway);
    }
}