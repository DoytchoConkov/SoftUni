package com.example.exercises.services;

import com.example.exercises.models.dtos.ProductInRangeDTO;
import com.example.exercises.models.dtos.ProductSeedDTO;

import java.util.List;

public interface ProductServices {
    void seedProduct(List<ProductSeedDTO> userSeedDTOList);

    List<ProductInRangeDTO> getProductsInRange();
}
