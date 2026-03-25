package com.example.zara.infraestructure.adapters;

import com.example.zara.domain.models.Price;
import com.example.zara.domain.ports.PriceRepoPort;
import com.example.zara.infraestructure.entities.PriceEntity;
import com.example.zara.infraestructure.repos.PriceJpaRepo;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepoAdapter implements PriceRepoPort {

    private final PriceJpaRepo priceJpaRepo;

    public PriceRepoAdapter(PriceJpaRepo priceJpaRepo) {
        this.priceJpaRepo = priceJpaRepo;
    }

    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceJpaRepo.findTopByProductAndBrandAndDate(applicationDate, productId, brandId)
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
