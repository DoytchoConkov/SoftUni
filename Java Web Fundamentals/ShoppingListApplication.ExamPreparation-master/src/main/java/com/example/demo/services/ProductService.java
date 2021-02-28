package com.example.demo.services;

import com.example.demo.models.entities.CategoryName;
import com.example.demo.models.services.ProductServiceModel;
import com.example.demo.models.views.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void addProduct(ProductServiceModel map);

    BigDecimal getTotalSum();

    void deleteAll();


    List<ProductViewModel> findByCategory(CategoryName categoryName);

    void delete(Long id);
}
