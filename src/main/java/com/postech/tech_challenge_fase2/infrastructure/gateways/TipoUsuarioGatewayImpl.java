package com.postech.tech_challenge_fase2.infrastructure.gateways;

import com.postech.tech_challenge_fase2.application.gateways.TipoUsuarioGateway;
import com.postech.tech_challenge_fase2.domain.entity.TipoUsuario;
import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.TipoUsuarioEntity;
import com.postech.tech_challenge_fase2.infrastructure.persistence.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TipoUsuarioGatewayImpl implements TipoUsuarioGateway {

    private final TipoUsuarioRepository repository;

    public TipoUsuarioGatewayImpl(TipoUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        // Traduz do Domínio para o JPA
        TipoUsuarioEntity entity = new TipoUsuarioEntity(tipoUsuario.getId(), tipoUsuario.getNome());
        
        // Salva no banco de dados
        TipoUsuarioEntity savedEntity = repository.save(entity);
        
        // Devolve como Domínio novamente
        return new TipoUsuario(savedEntity.getId(), savedEntity.getNome());
    }

    @Override
    public Optional<TipoUsuario> buscarPorId(Long id) {
        return repository.findById(id)
                .map(entity -> new TipoUsuario(entity.getId(), entity.getNome()));
    }

    @Override
    public List<TipoUsuario> listarTodos() {
        return repository.findAll().stream()
                .map(entity -> new TipoUsuario(entity.getId(), entity.getNome()))
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}