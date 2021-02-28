package com.example.mobilelele.models.dtos;

import com.example.mobilelele.models.entities.Brand;
import com.example.mobilelele.models.entities.Category;
import com.google.gson.annotations.Expose;

import java.time.LocalDate;

public class ModelSeedDto {
    @Expose
    private String name;
    @Expose
    private String category;
    @Expose
    private String imageURL;
    @Expose
    private int startYear;
    @Expose
    private int endYear;
    @Expose
    private String brand;

    public ModelSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
