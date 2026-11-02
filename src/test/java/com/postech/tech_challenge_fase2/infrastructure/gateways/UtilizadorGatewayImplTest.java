package com.postech.tech_challenge_fase2.infrastructure.gateways;

import com.postech.tech_challenge_fase2.domain.entity.Utilizador;
import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.UtilizadorEntity;
import com.postech.tech_challenge_fase2.infrastructure.persistence.repository.UtilizadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UtilizadorGatewayImplTest {

    @Mock
    private UtilizadorRepository repository;

    @InjectMocks
    private UtilizadorGatewayImpl utilizadorGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarUtilizadorComSucesso() {
        Utilizador utilizador = new Utilizador(null, "Ana", "ana@email.com", 1L);
        UtilizadorEntity entity = new UtilizadorEntity(1L, "Ana", "ana@email.com", 1L);
        when(repository.save(any(UtilizadorEntity.class))).thenReturn(entity);

        Utilizador salvo = utilizadorGateway.salvar(utilizador);

        assertNotNull(salvo);
        assertEquals(1L, salvo.getId());
        verify(repository, times(1)).save(any(UtilizadorEntity.class));
    }
}