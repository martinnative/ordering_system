package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Model.Ingredient;
import com.ulaf.ste.ordering_system.Repository.IngredientsRepository;
import com.ulaf.ste.ordering_system.Service.IngredientService;

import java.util.List;

public class IngredientServiceImpl implements IngredientService {
    private final IngredientsRepository ingredientsRepository;

    public IngredientServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientsRepository.findAll();
    }
    @Override
    public Ingredient updateIngredient(Long id, String name) {
        Ingredient ingredient = ingredientsRepository.findById(id).orElse(null);
        if (ingredient != null) {
            ingredient.setName(name);
            return ingredientsRepository.save(ingredient);
        }
        return null;
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientsRepository.delete(ingredient);
    }
}