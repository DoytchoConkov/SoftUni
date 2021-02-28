package com.example.mobilelele.services;

import com.example.mobilelele.models.dtos.ModelSeedDto;
import com.example.mobilelele.models.entities.Model;
import com.example.mobilelele.models.view.ModelAddViewModel;

public interface ModelServices {
    void seedModels(ModelSeedDto[] dtos);

    Model getModel(String model);

    boolean addModel(ModelAddViewModel modelAddViewModel);
}
