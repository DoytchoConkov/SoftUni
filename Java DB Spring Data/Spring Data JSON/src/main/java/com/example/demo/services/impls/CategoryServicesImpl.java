package com.example.demo.services.impls;

import com.example.demo.models.dtos.CategorySeedDTO;
import com.example.demo.models.entities.Category;
import com.example.demo.repositories.CategoryReposytory;
import com.example.demo.services.CategoryServices;
import com.example.demo.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class CategoryServicesImpl implements CategoryServices {
    private final CategoryReposytory categoryRepo;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CategoryServicesImpl(CategoryReposytory categoryRepo, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(CategorySeedDTO[] categorySeedDTOS) {
        if (this.categoryRepo.count() > 0) {
            return;
        }
        Arrays.stream(categorySeedDTOS).forEach(cat -> {
            if (this.validationUtil.isValid(cat)) {
                Category category = this.modelMapper.map(cat, Category.class);
                this.categoryRepo.saveAndFlush(category);
            } else {
                this.validationUtil
                        .getViolations(cat)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();
        Set<Category> categories=new LinkedHashSet<>();
        int cnt=random.nextInt(3)+1;
        for (int i = 0; i < cnt; i++) {
            long id=random.nextInt((int) this.categoryRepo.count())+1;
            categories.add(this.categoryRepo.getOne(id));
        }
        return categories;
    }
}
