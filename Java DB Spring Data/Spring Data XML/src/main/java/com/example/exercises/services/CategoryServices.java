package com.example.exercises.services;

import com.example.exercises.models.dtos.CategorySeedDTO;
import com.example.exercises.models.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryServices {
    void seedCategory(List<CategorySeedDTO> categorySeedDTO);

    Set<Category> getRandomCategories();
}
