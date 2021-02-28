package com.example.spring_data_auto_maping.domains.DTOs;

import java.math.BigDecimal;

public class AllGamesDTO {
    private String title;
    private BigDecimal price;

    public AllGamesDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
