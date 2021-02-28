package com.example.mobilelele.models.view;

import java.util.List;

public class BrandsOfferViewModel {
    private String name;
    private List<String> model;

    public BrandsOfferViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getModel() {
        return model;
    }

    public void setModel(List<String> model) {
        this.model = model;
    }
}
