package com.example.zara.application;

import com.example.zara.application.GetPriceUseCase;
import com.example.zara.domain.models.Price;
import com.example.zara.domain.ports.PriceRepoPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GetPriceService implements GetPriceUseCase {

    private final PriceRepoPort priceRepoPort;

    public GetPriceService(PriceRepoPort priceRepoPort) {
        this.priceRepoPort = priceRepoPort;
    }

    @Override
    public Price getApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceRepoPort.findApplicablePrice(applicationDate, productId, brandId)
                .orElseThrow(() -> new RuntimeException("Precio no encontrado para los parametros dados"));
    }
}