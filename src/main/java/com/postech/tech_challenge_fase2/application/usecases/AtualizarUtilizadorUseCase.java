package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;
import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;

public class AtualizarUtilizadorUseCase {
    private final UtilizadorGateway utilizadorGateway;

    public AtualizarUtilizadorUseCase(UtilizadorGateway utilizadorGateway) {
        this.utilizadorGateway = utilizadorGateway;
    }

    public Utilizador executar(Long id, Utilizador dadosAtualizados) {
        Utilizador utilizador = utilizadorGateway.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Utilizador não encontrado com o ID: " + id));

        utilizador.setNome(dadosAtualizados.getNome());
        utilizador.setEmail(dadosAtualizados.getEmail());
        utilizador.setIdTipoUsuario(dadosAtualizados.getIdTipoUsuario());

        return utilizadorGateway.salvar(utilizador);
    }
}