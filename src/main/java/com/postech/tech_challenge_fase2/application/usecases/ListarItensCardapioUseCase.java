package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;
import java.util.List;

public class ListarItensCardapioUseCase {
    private final ItemCardapioGateway itemCardapioGateway;

    public ListarItensCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public List<ItemCardapio> executar() {
        return itemCardapioGateway.listarTodos();
    }
}