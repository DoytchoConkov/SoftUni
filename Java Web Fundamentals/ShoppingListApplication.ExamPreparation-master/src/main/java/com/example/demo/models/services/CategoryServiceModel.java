package com.example.demo.models.services;

import com.example.demo.models.entities.CategoryName;

public class CategoryServiceModel extends BaseServiceModel{
    private CategoryName name;
    private String description;

    public CategoryServiceModel() {
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
