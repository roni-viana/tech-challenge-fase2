package com.postech.tech_challenge_fase2.infrastructure.gateways;

import com.postech.tech_challenge_fase2.application.gateways.ItemCardapioGateway;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;
import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.ItemCardapioEntity;
import com.postech.tech_challenge_fase2.infrastructure.persistence.repository.ItemCardapioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ItemCardapioGatewayImpl implements ItemCardapioGateway {

    private final ItemCardapioRepository repository;

    public ItemCardapioGatewayImpl(ItemCardapioRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemCardapio salvar(ItemCardapio itemCardapio) {
        ItemCardapioEntity entity = new ItemCardapioEntity(
                itemCardapio.getId(),
                itemCardapio.getNome(),
                itemCardapio.getDescricao(),
                itemCardapio.getPreco(),
                itemCardapio.isApenasLocal(),
                itemCardapio.getCaminhoFoto(),
                itemCardapio.getIdRestaurante()
        );

        ItemCardapioEntity savedEntity = repository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<ItemCardapio> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<ItemCardapio> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private ItemCardapio toDomain(ItemCardapioEntity entity) {
        return new ItemCardapio(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getPreco(),
                entity.isApenasLocal(),
                entity.getCaminhoFoto(),
                entity.getIdRestaurante()
        );
    }
}