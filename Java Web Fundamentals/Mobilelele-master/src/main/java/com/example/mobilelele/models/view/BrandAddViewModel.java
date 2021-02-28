package com.example.mobilelele.models.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BrandAddViewModel {
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    public BrandAddViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
