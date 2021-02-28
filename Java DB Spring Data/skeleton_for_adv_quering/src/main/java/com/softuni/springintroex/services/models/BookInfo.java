package com.softuni.springintroex.services.models;

import com.softuni.springintroex.entities.AgeRestriction;
import com.softuni.springintroex.entities.EditionType;

import java.math.BigDecimal;

public class BookInfo {

    private String title;
    private EditionType editionType;
    private BigDecimal price;
    private AgeRestriction ageRestriction;

    public BookInfo(String title, EditionType editionType, BigDecimal price, AgeRestriction ageRestriction) {
        this.title = title;
        this.editionType = editionType;
        this.price = price;
        this.ageRestriction = ageRestriction;
    }

    public String getTitle() {
        return title;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }
}
