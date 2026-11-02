package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;
import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;

public class BuscarUtilizadorPorIdUseCase {
    private final UtilizadorGateway utilizadorGateway;

    public BuscarUtilizadorPorIdUseCase(UtilizadorGateway utilizadorGateway) {
        this.utilizadorGateway = utilizadorGateway;
    }

    public Utilizador executar(Long id) {
        return utilizadorGateway.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Utilizador não encontrado com o ID: " + id));
    }
}