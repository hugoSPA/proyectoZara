package com.example.zara.infraestructure.adapters;

import com.example.zara.domain.models.Price;
import com.example.zara.domain.ports.PriceRepositoryPort;
import com.example.zara.infraestructure.entities.PriceEntity;
import com.example.zara.infraestructure.repository.PriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJpaRepository priceJpaRepository;

    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceJpaRepository.findTopByProductAndBrandAndDate(applicationDate, productId, brandId)
                .map(this::mapToDomain);
    }

    private Price mapToDomain(PriceEntity entity) {
        return Price.builder()
                .brandId(entity.getBrandId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .price(entity.getPrice().doubleValue())
                .currency(entity.getCurrency())
                .build();
    }
}
