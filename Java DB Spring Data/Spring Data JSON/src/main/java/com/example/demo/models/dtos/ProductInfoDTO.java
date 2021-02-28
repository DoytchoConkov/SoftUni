package com.example.demo.models.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductInfoDTO {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String buyer;

    public ProductInfoDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
