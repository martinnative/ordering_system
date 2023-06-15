package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Repository.CategoryRepository;
import com.ulaf.ste.ordering_system.Service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);

        if (existingCategory != null) {
            // Update the existing category with the new values
            existingCategory.setName(category.getName());
            // ...

            // Save the updated category
            return categoryRepository.save(existingCategory);
        }

        return null; // or throw an exception indicating that the category doesn't exist
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }
}