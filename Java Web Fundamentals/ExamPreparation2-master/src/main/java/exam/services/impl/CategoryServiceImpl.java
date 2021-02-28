package exam.services.impl;

import exam.repositories.CategoryRepository;
import exam.models.entities.Category;
import exam.models.entities.CategoryName;
import exam.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void init() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values()).forEach(c -> {
                Category category = new Category(c, String.format("This is description for %s", c.name()));
                categoryRepository.save(category);
            });
        }
    }

    @Override
    public Category findByCategoryName(CategoryName name) {
        return this.categoryRepository.findByName(name).orElse(null);
    }

}
