package com.example.exercises.services.impls;

import com.example.exercises.models.dtos.ProductInRangeDTO;
import com.example.exercises.models.dtos.ProductSeedDTO;
import com.example.exercises.models.entities.Product;
import com.example.exercises.repositories.ProductRepository;
import com.example.exercises.services.CategoryServices;
import com.example.exercises.services.ProductServices;
import com.example.exercises.services.UserServices;
import com.example.exercises.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServicesImpl implements ProductServices {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserServices userServices;
    private final CategoryServices categoryServices;

    @Autowired
    public ProductServicesImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserServices userServices, CategoryServices categoryServices) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userServices = userServices;
        this.categoryServices = categoryServices;
    }

    @Override
    public void seedProduct(List<ProductSeedDTO> productSeedDTOS) {
        productSeedDTOS.forEach(pro -> {
            if (this.validationUtil.isValid(pro)) {
                if (this.productRepository.findByName(pro.getName()) == null) {
                    Product product = this.modelMapper.map(pro, Product.class);
                    Random random = new Random();
                    if (random.nextBoolean()) {
                        product.setBuyer(this.userServices.getRandomUser());
                    }

                    product.setSeller(this.userServices.getRandomUser());
                    product.setCategories(this.categoryServices.getRandomCategories());
                    this.productRepository.saveAndFlush(product);
                } else {
                    System.out.println("DB have category with this name!");
                }
            } else {
                this.validationUtil
                        .getViolations(pro)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public List<ProductInRangeDTO> getProductsInRange() {
        return this.productRepository.findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream().map(prod -> {
                    ProductInRangeDTO product = this.modelMapper.map(prod, ProductInRangeDTO.class);
                    if (prod.getSeller().getFirstName()!=null) {
                        product.setSeller(String.format("%s %s", prod.getSeller().getFirstName(), prod.getSeller().getLastName()));
                    }else{
                        product.setSeller(String.format("%s", prod.getSeller().getLastName()));
                    }
                    return product;
                }).collect(Collectors.toList());
    }


}
