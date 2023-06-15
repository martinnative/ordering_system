package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);
    Ingredient getIngredientById(Long id) throws NotFoundByIdException;
    List<Ingredient> getAllIngredients();
    Ingredient updateIngredient(Long id, Ingredient ingredient) throws NotFoundByIdException;
    void deleteIngredient(Long id);
}
