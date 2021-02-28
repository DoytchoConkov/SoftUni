package exam.services;


import exam.models.entities.Category;
import exam.models.entities.CategoryName;

public interface CategoryService {

    void init();


    Category findByCategoryName(CategoryName name);
}
