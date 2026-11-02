package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;
import java.util.List;

public class ListarUtilizadoresUseCase {
    private final UtilizadorGateway utilizadorGateway;

    public ListarUtilizadoresUseCase(UtilizadorGateway utilizadorGateway) {
        this.utilizadorGateway = utilizadorGateway;
    }

    public List<Utilizador> executar() {
        return utilizadorGateway.listarTodos();
    }
}