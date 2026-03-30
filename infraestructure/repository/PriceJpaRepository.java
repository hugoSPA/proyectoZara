package com.example.zara.infraestructure.repository;

import com.example.zara.infraestructure.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND :appDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC LIMIT 1")
    Optional<PriceEntity> findTopByProductAndBrandAndDate(
            @Param("appDate") LocalDateTime appDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);
}
