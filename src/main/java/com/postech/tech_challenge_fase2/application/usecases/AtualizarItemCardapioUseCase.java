package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.exception.EntidadeNaoEncontradaException;
import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;

public class AtualizarItemCardapioUseCase {
    private final ItemCardapioGateway itemCardapioGateway;

    public AtualizarItemCardapioUseCase(ItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public ItemCardapio executar(Long id, ItemCardapio dadosAtualizados) {
        ItemCardapio item = itemCardapioGateway.buscarPorId(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Item do cardápio não encontrado com o ID: " + id));

        item.setNome(dadosAtualizados.getNome());
        item.setDescricao(dadosAtualizados.getDescricao());
        item.setPreco(dadosAtualizados.getPreco());
        item.setApenasLocal(dadosAtualizados.isApenasLocal());
        item.setCaminhoFoto(dadosAtualizados.getCaminhoFoto());
        // O idRestaurante normalmente não muda para um prato, por isso mantemos o original

        return itemCardapioGateway.salvar(item);
    }
}