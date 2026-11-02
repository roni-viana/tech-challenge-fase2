package com.postech.tech_challenge_fase2.infrastructure.config;

import com.postech.tech_challenge_fase2.application.gateways.TipoUsuarioGateway;
import com.postech.tech_challenge_fase2.application.usecases.CriarTipoUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoUsuarioConfig {

    @Bean
    public CriarTipoUsuarioUseCase criarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        return new CriarTipoUsuarioUseCase(tipoUsuarioGateway);
    }
}