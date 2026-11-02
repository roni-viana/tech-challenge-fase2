package com.postech.tech_challenge_fase2.infrastructure.controllers;

import com.postech.tech_challenge_fase2.application.usecases.CriarTipoUsuarioUseCase;
import com.postech.tech_challenge_fase2.domain.entity.TipoUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipos-usuario")
public class TipoUsuarioController {

    private final CriarTipoUsuarioUseCase criarTipoUsuarioUseCase;

    public TipoUsuarioController(CriarTipoUsuarioUseCase criarTipoUsuarioUseCase) {
        this.criarTipoUsuarioUseCase = criarTipoUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> criar(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioCriado = criarTipoUsuarioUseCase.executar(tipoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarioCriado);
    }
}