package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;
import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;

public class AtualizarRestauranteUseCase {

    private final RestauranteGateway restauranteGateway;

    public AtualizarRestauranteUseCase(RestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public Restaurante executar(Long id, Restaurante dadosAtualizados) {
        Restaurante restaurante = restauranteGateway.buscarPorId(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException("Restaurante não encontrado com o ID: " + id));

        restaurante.setNome(dadosAtualizados.getNome());
        restaurante.setEndereco(dadosAtualizados.getEndereco());
        restaurante.setTipoCozinha(dadosAtualizados.getTipoCozinha());
        restaurante.setHorarioFuncionamento(dadosAtualizados.getHorarioFuncionamento());
        // O id do Dono normalmente não muda, por isso mantemos o original

        return restauranteGateway.salvar(restaurante);
    }
}