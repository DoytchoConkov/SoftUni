package com.example.demo.services.impls;

import com.example.demo.models.dtos.*;
import com.example.demo.models.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.CategoryServices;
import com.example.demo.services.ProductServices;
import com.example.demo.services.UserServices;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServicesImpl implements ProductServices {
    private final ProductRepository productRepo;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserServices userServices;
    private final CategoryServices categoryServices;

    @Autowired
    public ProductServicesImpl(ProductRepository productRepo, ModelMapper modelMapper, ValidationUtil validationUtil, UserServices userServices, CategoryServices categoryServices) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userServices = userServices;
        this.categoryServices = categoryServices;
    }


    @Override
    public void seedProducts(ProductSeedDTO[] productSeedDTOS) {
        if (this.productRepo.count() > 0) {
            return;
        }

        Arrays.stream(productSeedDTOS).forEach(prod -> {
            if (this.validationUtil.isValid(prod)) {
                Product product = this.modelMapper.map(prod, Product.class);
                Random random = new Random();
                if (random.nextBoolean()) {
                    product.setBuyer(this.userServices.getRandomUser());
                }

                product.setSeller(this.userServices.getRandomUser());
                product.setCategories(this.categoryServices.getRandomCategories());
                this.productRepo.saveAndFlush(product);
            } else {
                this.validationUtil
                        .getViolations(prod)
                        .stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public List<ProductInRangeDTO> getProductsInRange() {
        return this.productRepo.findAllByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500), BigDecimal.valueOf(1000))
                .stream().map(prod -> {
                    ProductInRangeDTO product = this.modelMapper.map(prod, ProductInRangeDTO.class);
                    product.setSeller(String.format("%s %s", prod.getSeller().getFirstName(), prod.getSeller().getLastName()));
                    return product;
                }).collect(Collectors.toList());
    }

    @Override
    public Set<ProductWithBuyerDTO> getProductWithBuyers() {
        return this.productRepo.findAllByBuyerOrderBySellerDesc().stream().map(pr -> {
            ProductWithBuyerDTO product=new ProductWithBuyerDTO(pr.getSeller());
            System.out.println();
            return product;
        }).collect(Collectors.toSet());
    }

    @Override
    public List<ProductInfoDTO> getListOfSellers(Set<ProductWithBuyerDTO> users) {
        List<ProductInfoDTO> result= new ArrayList<>();
        users.stream().map(u->{
       return this.modelMapper.map(this.productRepo.findBySeller(u.getUser()),ProductInfoDTO.class);
        }).collect(Collectors.toList());

        return result;
    }


}
