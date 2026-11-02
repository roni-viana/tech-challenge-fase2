package com.postech.tech_challenge_fase2.application.gateways;

import com.postech.tech_challenge_fase2.domain.entity.Utilizador;
import java.util.List;
import java.util.Optional;

public interface UtilizadorGateway {
    Utilizador salvar(Utilizador utilizador);
    Optional<Utilizador> buscarPorId(Long id);
    List<Utilizador> listarTodos();
    void deletar(Long id);
}