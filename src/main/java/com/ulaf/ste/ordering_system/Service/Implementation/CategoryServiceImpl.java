package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
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
    public Category getCategoryById(Long id) throws NotFoundByIdException {
        return categoryRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Category with the provided ID was not found"));
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category category) throws NotFoundByIdException {
        Category existingCategory = this.getCategoryById(id);

        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }
    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
