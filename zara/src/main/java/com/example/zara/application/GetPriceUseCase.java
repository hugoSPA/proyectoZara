package com.example.zara.application;

import com.example.zara.domain.models.Price;
import java.time.LocalDateTime;

public interface GetPriceUseCase {
    Price getApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId);
}