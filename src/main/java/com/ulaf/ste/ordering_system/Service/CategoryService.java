package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    void deleteCategory(Category category);
}