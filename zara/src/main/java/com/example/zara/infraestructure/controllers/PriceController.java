package com.example.zara.infraestructure.controllers;

import com.example.zara.application.GetPriceUseCase;
import com.example.zara.domain.models.Price;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final GetPriceUseCase getPriceUseCase;

    public PriceController(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId) {

        Price price = getPriceUseCase.getApplicablePrice(applicationDate, productId, brandId);

        PriceResponse response = new PriceResponse();
        response.setProductId(price.getProductId());
        response.setBrandId(price.getBrandId());
        response.setPriceList(price.getPriceList());
        response.setStartDate(price.getStartDate());
        response.setEndDate(price.getEndDate());
        response.setPrice(price.getPrice());

        return ResponseEntity.ok(response);
    }

    public static class PriceResponse {
        private Long productId;
        private Long brandId;
        private Integer priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Double price;

        public PriceResponse() {}

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Long getBrandId() {
            return brandId;
        }

        public void setBrandId(Long brandId) {
            this.brandId = brandId;
        }

        public Integer getPriceList() {
            return priceList;
        }

        public void setPriceList(Integer priceList) {
            this.priceList = priceList;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
        }

        public LocalDateTime getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}