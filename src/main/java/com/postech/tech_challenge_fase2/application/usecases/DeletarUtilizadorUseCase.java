package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;

public class DeletarUtilizadorUseCase {
    private final UtilizadorGateway utilizadorGateway;

    public DeletarUtilizadorUseCase(UtilizadorGateway utilizadorGateway) {
        this.utilizadorGateway = utilizadorGateway;
    }

    public void executar(Long id) {
        utilizadorGateway.deletar(id);
    }
}