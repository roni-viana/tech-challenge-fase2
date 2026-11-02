package com.postech.tech_challenge_fase2.infrastructure.gateways;

import com.postech.tech_challenge_fase2.domain.entity.ItemCardapio;
import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.ItemCardapioEntity;
import com.postech.tech_challenge_fase2.infrastructure.persistence.repository.ItemCardapioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ItemCardapioGatewayImplTest {

    @Mock
    private ItemCardapioRepository repository;

    @InjectMocks
    private ItemCardapioGatewayImpl itemCardapioGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarItemCardapioComSucesso() {
        ItemCardapio item = new ItemCardapio(null, "Suco", "Laranja", new BigDecimal("10.0"), false, "", 1L);
        ItemCardapioEntity entity = new ItemCardapioEntity(1L, "Suco", "Laranja", new BigDecimal("10.0"), false, "", 1L);
        when(repository.save(any(ItemCardapioEntity.class))).thenReturn(entity);

        ItemCardapio salvo = itemCardapioGateway.salvar(item);

        assertNotNull(salvo);
        assertEquals(1L, salvo.getId());
        verify(repository, times(1)).save(any(ItemCardapioEntity.class));
    }
}