package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category findRandomCategory(long id);
}
