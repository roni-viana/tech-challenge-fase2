package com.postech.tech_challenge_fase2.infrastructure.controllers;

import com.postech.tech_challenge_fase2.application.usecases.*;
import com.postech.tech_challenge_fase2.domain.entity.Utilizador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utilizadores")
public class UtilizadorController {

    private final CriarUtilizadorUseCase criarUtilizadorUseCase;
    private final ListarUtilizadoresUseCase listarUtilizadoresUseCase;
    private final BuscarUtilizadorPorIdUseCase buscarUtilizadorPorIdUseCase;
    private final AtualizarUtilizadorUseCase atualizarUtilizadorUseCase;
    private final DeletarUtilizadorUseCase deletarUtilizadorUseCase;

    public UtilizadorController(CriarUtilizadorUseCase criarUtilizadorUseCase,
                                ListarUtilizadoresUseCase listarUtilizadoresUseCase,
                                BuscarUtilizadorPorIdUseCase buscarUtilizadorPorIdUseCase,
                                AtualizarUtilizadorUseCase atualizarUtilizadorUseCase,
                                DeletarUtilizadorUseCase deletarUtilizadorUseCase) {
        this.criarUtilizadorUseCase = criarUtilizadorUseCase;
        this.listarUtilizadoresUseCase = listarUtilizadoresUseCase;
        this.buscarUtilizadorPorIdUseCase = buscarUtilizadorPorIdUseCase;
        this.atualizarUtilizadorUseCase = atualizarUtilizadorUseCase;
        this.deletarUtilizadorUseCase = deletarUtilizadorUseCase;
    }

    @PostMapping
    public ResponseEntity<Utilizador> criar(@RequestBody Utilizador utilizador) {
        Utilizador utilizadorCriado = criarUtilizadorUseCase.executar(utilizador);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilizadorCriado);
    }

    @GetMapping
    public ResponseEntity<List<Utilizador>> listar() {
        return ResponseEntity.ok(listarUtilizadoresUseCase.executar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilizador> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(buscarUtilizadorPorIdUseCase.executar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilizador> atualizar(@PathVariable Long id, @RequestBody Utilizador utilizador) {
        return ResponseEntity.ok(atualizarUtilizadorUseCase.executar(id, utilizador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        deletarUtilizadorUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}