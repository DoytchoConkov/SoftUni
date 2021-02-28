package com.example.demo.services.impl;

import com.example.demo.models.entities.CategoryName;
import com.example.demo.models.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count()!=0){
            return;
        }
        Arrays.stream(CategoryName.values()).forEach(c -> {
            Category category = new Category(c, String.format("This is description for %s", c.name()));
            categoryRepository.save(category);});
    }

    @Override
    public Category findCategory(CategoryName name) {
        return this.categoryRepository.findByName(name).orElse(null);
    }


}
