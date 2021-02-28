package com.example.mobilelele.models.dtos;

import com.google.gson.annotations.Expose;

import java.time.LocalDate;

public class BrandSeedDto {
    @Expose
    private String name;

    public BrandSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
