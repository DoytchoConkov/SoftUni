package com.example.demo.services.impl;

import com.example.demo.models.entities.Category;
import com.example.demo.models.entities.CategoryName;
import com.example.demo.models.entities.Product;
import com.example.demo.models.services.ProductServiceModel;
import com.example.demo.models.views.ProductViewModel;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel, Product.class);
        Category category = this.categoryService.findCategory(productServiceModel.getCategory().getName());
        product.setCategory(category);
        this.productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return this.productRepository.findTotalPriceSum();
    }

    @Override
    public void deleteAll() {
        this.productRepository.deleteAll();
    }

    @Override
    public List<ProductViewModel> findByCategory(CategoryName categoryName) {
        return this.productRepository.findAllByCategory_Name(categoryName).stream().map(pr -> modelMapper
                .map(pr, ProductViewModel.class)).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
