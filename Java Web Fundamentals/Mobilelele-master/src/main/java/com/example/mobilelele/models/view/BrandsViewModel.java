package com.example.mobilelele.models.view;

import java.util.List;

public class BrandsViewModel {
    private String name;
    private List<ModelViewModel> model;

    public BrandsViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelViewModel> getModel() {
        return model;
    }

    public void setModel(List<ModelViewModel> model) {
        this.model = model;
    }
}
