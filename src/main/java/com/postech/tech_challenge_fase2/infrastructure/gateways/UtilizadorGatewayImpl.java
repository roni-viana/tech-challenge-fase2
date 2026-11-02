package com.postech.tech_challenge_fase2.infrastructure.gateways;

import com.postech.tech_challenge_fase2.application.gateways.UtilizadorGateway;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;
import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.UtilizadorEntity;
import com.postech.tech_challenge_fase2.infrastructure.persistence.repository.UtilizadorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UtilizadorGatewayImpl implements UtilizadorGateway {

    private final UtilizadorRepository repository;

    public UtilizadorGatewayImpl(UtilizadorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Utilizador salvar(Utilizador utilizador) {
        UtilizadorEntity entity = new UtilizadorEntity(
                utilizador.getId(),
                utilizador.getNome(),
                utilizador.getEmail(),
                utilizador.getIdTipoUsuario()
        );
        
        UtilizadorEntity savedEntity = repository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Utilizador> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Utilizador> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private Utilizador toDomain(UtilizadorEntity entity) {
        return new Utilizador(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getIdTipoUsuario()
        );
    }
}