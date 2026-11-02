package com.postech.tech_challenge_fase2.infrastructure.controllers;

import com.postech.tech_challenge_fase2.application.usecases.*;
import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itens-cardapio")
public class ItemCardapioController {

    private final CriarItemCardapioUseCase criarItemCardapioUseCase;
    private final ListarItensCardapioUseCase listarItensCardapioUseCase;
    private final BuscarItemCardapioPorIdUseCase buscarItemCardapioPorIdUseCase;
    private final AtualizarItemCardapioUseCase atualizarItemCardapioUseCase;
    private final DeletarItemCardapioUseCase deletarItemCardapioUseCase;

    public ItemCardapioController(CriarItemCardapioUseCase criarItemCardapioUseCase,
                                  ListarItensCardapioUseCase listarItensCardapioUseCase,
                                  BuscarItemCardapioPorIdUseCase buscarItemCardapioPorIdUseCase,
                                  AtualizarItemCardapioUseCase atualizarItemCardapioUseCase,
                                  DeletarItemCardapioUseCase deletarItemCardapioUseCase) {
        this.criarItemCardapioUseCase = criarItemCardapioUseCase;
        this.listarItensCardapioUseCase = listarItensCardapioUseCase;
        this.buscarItemCardapioPorIdUseCase = buscarItemCardapioPorIdUseCase;
        this.atualizarItemCardapioUseCase = atualizarItemCardapioUseCase;
        this.deletarItemCardapioUseCase = deletarItemCardapioUseCase;
    }

    @PostMapping
    public ResponseEntity<ItemCardapio> criar(@RequestBody ItemCardapio itemCardapio) {
        ItemCardapio criado = criarItemCardapioUseCase.executar(itemCardapio);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public ResponseEntity<List<ItemCardapio>> listar() {
        return ResponseEntity.ok(listarItensCardapioUseCase.executar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCardapio> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(buscarItemCardapioPorIdUseCase.executar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCardapio> atualizar(@PathVariable Long id, @RequestBody ItemCardapio itemCardapio) {
        return ResponseEntity.ok(atualizarItemCardapioUseCase.executar(id, itemCardapio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        deletarItemCardapioUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}