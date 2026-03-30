package com.example.zara.application;

import com.example.zara.domain.models.Price;
import com.example.zara.domain.ports.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GetPriceService implements GetPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    @Override
    public Price getApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceRepositoryPort.findApplicablePrice(applicationDate, productId, brandId)
                .orElseThrow(() -> new RuntimeException("Precio no encontrado para los parametros dados"));
    }
}