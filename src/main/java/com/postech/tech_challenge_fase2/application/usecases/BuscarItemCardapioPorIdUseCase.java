package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;
import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;

public class BuscarItemCardapioPorIdUseCase {
    private final ItemCardapioGateway itemCardapioGateway;

    public BuscarItemCardapioPorIdUseCase(ItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public ItemCardapio executar(Long id) {
        return itemCardapioGateway.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Item do cardápio não encontrado com o ID: " + id));
    }
}