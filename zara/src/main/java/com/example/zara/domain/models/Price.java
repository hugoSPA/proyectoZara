package com.example.zara.domain.models;

import java.time.LocalDateTime;

public class Price {
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;

    public Price() {}

    public Price(Long brandId, String currency, Double price, Integer priority, Long productId, Integer priceList, LocalDateTime endDate, LocalDateTime startDate) {
        this.brandId = brandId;
        this.currency = currency;
        this.price = price;
        this.priority = priority;
        this.productId = productId;
        this.priceList = priceList;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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

    public Integer getPriceList() {
        return priceList;
    }

    public void setPriceList(Integer priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Price p = new Price();

        public Builder brandId(Long brandId) {
            p.setBrandId(brandId); return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            p.setStartDate(startDate); return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            p.setEndDate(endDate); return this;
        }

        public Builder priceList(Integer priceList) {
            p.setPriceList(priceList); return this;
        }

        public Builder productId(Long productId) {
            p.setProductId(productId); return this;
        }

        public Builder priority(Integer priority) {
            p.setPriority(priority); return this;
        }

        public Builder price(Double price) {
            p.setPrice(price); return this;
        }

        public Builder currency(String currency) {
            p.setCurrency(currency); return this;
        }

        public Price build() {
            return p;
        }
    }
}