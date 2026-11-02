package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;

public class CriarUtilizadorUseCase {

    private final UtilizadorGateway utilizadorGateway;

    public CriarUtilizadorUseCase(UtilizadorGateway utilizadorGateway) {
        this.utilizadorGateway = utilizadorGateway;
    }

    public Utilizador executar(Utilizador utilizador) {
        return utilizadorGateway.salvar(utilizador);
    }
}