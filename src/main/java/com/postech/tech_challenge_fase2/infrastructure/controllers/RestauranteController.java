package com.postech.tech_challenge_fase2.infrastructure.controllers;

import com.postech.tech_challenge_fase2.application.usecases.*;
import com.postech.tech_challenge_fase2.domain.entity.Restaurante;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurantes")
public class RestauranteController {

    private final CriarRestauranteUseCase criarRestauranteUseCase;
    private final ListarRestaurantesUseCase listarRestaurantesUseCase;
    private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;
    private final AtualizarRestauranteUseCase atualizarRestauranteUseCase;
    private final DeletarRestauranteUseCase deletarRestauranteUseCase;

    public RestauranteController(CriarRestauranteUseCase criarRestauranteUseCase, 
                                 ListarRestaurantesUseCase listarRestaurantesUseCase,
                                 BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase,
                                 AtualizarRestauranteUseCase atualizarRestauranteUseCase,
                                 DeletarRestauranteUseCase deletarRestauranteUseCase) {
        this.criarRestauranteUseCase = criarRestauranteUseCase;
        this.listarRestaurantesUseCase = listarRestaurantesUseCase;
        this.buscarRestaurantePorIdUseCase = buscarRestaurantePorIdUseCase;
        this.atualizarRestauranteUseCase = atualizarRestauranteUseCase;
        this.deletarRestauranteUseCase = deletarRestauranteUseCase;
    }

    @PostMapping
    public ResponseEntity<Restaurante> criar(@RequestBody Restaurante restaurante) {
        Restaurante restauranteCriado = criarRestauranteUseCase.executar(restaurante);
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteCriado);
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> listar() {
        List<Restaurante> restaurantes = listarRestaurantesUseCase.executar();
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long id) {
        Restaurante restaurante = buscarRestaurantePorIdUseCase.executar(id);
        return ResponseEntity.ok(restaurante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        Restaurante restauranteAtualizado = atualizarRestauranteUseCase.executar(id, restaurante);
        return ResponseEntity.ok(restauranteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        deletarRestauranteUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}