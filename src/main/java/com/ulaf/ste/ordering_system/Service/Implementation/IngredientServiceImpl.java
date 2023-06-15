package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Ingredient;
import com.ulaf.ste.ordering_system.Repository.IngredientsRepository;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    public Ingredient getIngredientById(Long id) throws NotFoundByIdException {
        return ingredientsRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Ingredient not found by id"));
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientsRepository.findAll();
    }
    @Override
    public Ingredient updateIngredient(Long id, Ingredient ingredient) throws NotFoundByIdException {
        Ingredient existingIngredient = ingredientsRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Ingredient not found by id"));
        if (existingIngredient != null) {
            existingIngredient.setName(ingredient.getName());
            return ingredientsRepository.save(existingIngredient);
        }
        return null;
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientsRepository.deleteById(id);
    }
}
