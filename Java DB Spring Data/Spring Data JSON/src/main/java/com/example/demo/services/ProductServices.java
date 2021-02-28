package com.example.demo.services;

import com.example.demo.models.dtos.*;

import java.util.List;
import java.util.Set;

public interface ProductServices {
    void seedProducts(ProductSeedDTO[] productSeedDTOS);

    List<ProductInRangeDTO> getProductsInRange();
    Set<ProductWithBuyerDTO> getProductWithBuyers();

    List<ProductInfoDTO> getListOfSellers(Set<ProductWithBuyerDTO> users);
}
