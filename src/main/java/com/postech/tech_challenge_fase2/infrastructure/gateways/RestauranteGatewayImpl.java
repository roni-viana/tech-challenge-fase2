package com.postech.tech_challenge_fase2.infrastructure.gateways;

import com.postech.tech_challenge_fase2.application.gateways.RestauranteGateway;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;
import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.RestauranteEntity;
import com.postech.tech_challenge_fase2.infrastructure.persistence.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RestauranteGatewayImpl implements RestauranteGateway {

    private final RestauranteRepository repository;

    public RestauranteGatewayImpl(RestauranteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurante salvar(Restaurante restaurante) {
        RestauranteEntity entity = new RestauranteEntity(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHorarioFuncionamento(),
                restaurante.getIdDono()
        );
        
        RestauranteEntity savedEntity = repository.save(entity);
        
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Restaurante> buscarPorId(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Restaurante> listarTodos() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private Restaurante toDomain(RestauranteEntity entity) {
        return new Restaurante(
                entity.getId(),
                entity.getNome(),
                entity.getEndereco(),
                entity.getTipoCozinha(),
                entity.getHorarioFuncionamento(),
                entity.getIdDono()
        );
    }
}