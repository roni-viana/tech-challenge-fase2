package com.postech.tech_challenge_fase2.application.gateways;

import com.postech.tech_challenge_fase2.domain.entity.Restaurante;
import java.util.List;
import java.util.Optional;

public interface RestauranteGateway {
    Restaurante salvar(Restaurante restaurante);
    Optional<Restaurante> buscarPorId(Long id);
    List<Restaurante> listarTodos();
    void deletar(Long id);
}