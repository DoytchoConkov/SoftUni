package com.example.demo.services;

import com.example.demo.models.dtos.CategorySeedDTO;
import com.example.demo.models.entities.Category;

import java.util.Set;

public interface CategoryServices {
void seedCategories(CategorySeedDTO[] categorySeedDTOS);

    Set<Category> getRandomCategories();
}
