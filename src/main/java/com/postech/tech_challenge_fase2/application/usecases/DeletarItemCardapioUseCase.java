package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;

public class DeletarItemCardapioUseCase {
    private final ItemCardapioGateway itemCardapioGateway;

    public DeletarItemCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public void executar(Long id) {
        itemCardapioGateway.deletar(id);
    }
}