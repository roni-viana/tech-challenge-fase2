package com.postech.tech_challenge_fase2.application.gateways;

import com.postech.tech_challenge_fase2.domain.entity.TipoUsuario;
import java.util.List;
import java.util.Optional;

public interface TipoUsuarioGateway {
    TipoUsuario salvar(TipoUsuario tipoUsuario);
    Optional<TipoUsuario> buscarPorId(Long id);
    List<TipoUsuario> listarTodos();
    void deletar(Long id);
}