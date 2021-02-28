package com.example.mobilelele.services;

import com.example.mobilelele.models.entities.Brand;
import com.example.mobilelele.models.view.BrandsOfferViewModel;
import com.example.mobilelele.models.view.BrandsViewModel;

import java.util.List;

public interface BrandServices {
    Brand findBrand(String name);

    void createBrand(String name);

    List<BrandsViewModel> getAllBrands();

    List<BrandsOfferViewModel> getBrandsAndModels();

    boolean addBrand(String name);

    List<String> allBrands();
}
