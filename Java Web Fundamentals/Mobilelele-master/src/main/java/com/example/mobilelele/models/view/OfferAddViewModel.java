package com.example.mobilelele.models.view;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferAddViewModel {
    private Long id;
    @Size(min=2, max=20)
    private String model;
    @Size(min=2, max=20)
    private String engine;
    @Min(value = 1900)
    @Max(value = 2200)
    private int year;
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "1000000.00")
    private BigDecimal price;
    @Size(min=2, max=20)
    private String transmission;
    @Min(value = 1)
    @Max(value = 2000000)
    private int mileage;
    @Size(min=10, max=200)
    private String description;
    @Size(min=2, max=20)
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;

    public OfferAddViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageURL) {
        this.imageUrl = imageURL;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
