package com.example.demo.init;

import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInit implements CommandLineRunner {
    private final CategoryService categoryService;

    @Autowired
    public AppInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.initCategories();
    }

    private void initCategories() {
        this.categoryService.initCategories();
    }
}
