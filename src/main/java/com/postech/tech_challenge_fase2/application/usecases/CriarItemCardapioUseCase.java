package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;

public class CriarItemCardapioUseCase {
    private final ItemCardapioGateway itemCardapioGateway;

    public CriarItemCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public ItemCardapio executar(ItemCardapio itemCardapio) {
        return itemCardapioGateway.salvar(itemCardapio);
    }
}