package com.postech.tech_challenge_fase2.application.usecases;

import com.postech.tech_challenge_fase2.application.gateways.TipoUsuarioGateway;
import com.postech.tech_challenge_fase2.domain.entity.TipoUsuario;

public class CriarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public CriarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public TipoUsuario executar(TipoUsuario tipoUsuario) {
        // Se houvesse alguma regra de negócio complexa (ex: validar se o nome está vazio), 
        // colocaríamos aqui antes de mandar guardar.
        return tipoUsuarioGateway.salvar(tipoUsuario);
    }
}