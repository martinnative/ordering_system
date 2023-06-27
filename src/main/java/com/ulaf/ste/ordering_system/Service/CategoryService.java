package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long id) throws NotFoundByIdException;
    List<Category> getAllCategories();
    Category updateCategory(Long id, Category category) throws NotFoundByIdException;
    void deleteCategory(Long id);
}
