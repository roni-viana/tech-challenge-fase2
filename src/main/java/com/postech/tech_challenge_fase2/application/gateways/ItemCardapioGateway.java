package com.postech.tech_challenge_fase2.application.gateways;

import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;
import java.util.List;
import java.util.Optional;

public interface ItemCardapioGateway {
    ItemCardapio salvar(ItemCardapio itemCardapio);
    Optional<ItemCardapio> buscarPorId(Long id);
    List<ItemCardapio> listarTodos();
    void deletar(Long id);
}