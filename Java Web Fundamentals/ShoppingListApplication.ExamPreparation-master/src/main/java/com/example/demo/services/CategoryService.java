package com.example.demo.services;

import com.example.demo.models.entities.Category;
import com.example.demo.models.entities.CategoryName;

public interface CategoryService {
    void initCategories();


    Category findCategory(CategoryName name);
}
