package com.example.exercises.services.impls;

import com.example.exercises.models.dtos.CategorySeedDTO;
import com.example.exercises.models.entities.Category;
import com.example.exercises.repositories.CategoryRepository;
import com.example.exercises.services.CategoryServices;
import com.example.exercises.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class CategoryServicesImpl implements CategoryServices {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public CategoryServicesImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategory(List<CategorySeedDTO> categorySeedDTO) {

        categorySeedDTO.forEach(cat -> {
            if (this.validationUtil.isValid(cat)) {
                if (this.categoryRepository.findByName(cat.getName()) == null) {
                    Category category = this.modelMapper.map(cat, Category.class);
                    this.categoryRepository.saveAndFlush(category);
                } else {
                    System.out.println("DB have category with this name!");
                }
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
            long id=random.nextInt((int) this.categoryRepository.count())+1;
            categories.add(this.categoryRepository.getOne(id));
        }
        return categories;
    }
}
