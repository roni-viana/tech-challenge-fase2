package com.postech.tech_challenge_fase2.infrastructure.persistence.repository;

import com.postech.tech_challenge_fase2.infrastructure.persistence.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
}