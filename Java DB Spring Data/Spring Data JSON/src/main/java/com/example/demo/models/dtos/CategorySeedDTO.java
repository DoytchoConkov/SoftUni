package com.example.demo.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

public class CategorySeedDTO {
    @Expose
    @Length(min = 3, max = 15,message = "Wrong category name!")
    private String name;

    public CategorySeedDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
