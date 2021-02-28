package com.example.demo.models.dtos;

import com.example.demo.models.entities.User;
import com.google.gson.annotations.Expose;

public class ProductWithBuyerDTO {
    @Expose
    private User seller;

    public ProductWithBuyerDTO() {
    }

    public ProductWithBuyerDTO(User seller) {
        this.seller = seller;
    }

    public User getUser() {
        return seller;
    }

    public void setUser(User seller) {
        this.seller = seller;
    }
}
