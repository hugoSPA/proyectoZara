package com.example.zara.domain.ports;

import com.example.zara.domain.models.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {

    Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId);

}