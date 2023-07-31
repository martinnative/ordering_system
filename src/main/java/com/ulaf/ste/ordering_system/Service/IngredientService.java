package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Ingredient;
import com.ulaf.ste.ordering_system.Repository.IngredientsRepository;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientService {
    private final IngredientsRepository ingredientsRepository;

    public IngredientService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id) throws NotFoundByIdException {
        return ingredientsRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Ingredient with the provided ID was not found"));
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientsRepository.findAll();
    }
    public Ingredient updateIngredient(Long id, Ingredient ingredient) throws NotFoundByIdException {
        Ingredient existingIngredient = this.getIngredientById(id);
        if (existingIngredient != null) {
            existingIngredient.setName(ingredient.getName());
            return ingredientsRepository.save(existingIngredient);
        }
        return null;
    }

    public Ingredient findByName(String name) {
        return ingredientsRepository.findByName(name);
    }

    public void deleteIngredient(Long id) {
        ingredientsRepository.deleteById(id);
    }

//    @Override
//    public Ingredient uploadImage(Long id, MultipartFile file) throws NotFoundByIdException, IOException {
//        Ingredient ingredient = getIngredientById(id);
//        if (ingredient != null) {
//            byte[] imageBytes = file.getBytes();
//            ingredient.setImage(imageBytes);
//            return ingredientsRepository.save(ingredient);
//        }
//        throw new NotFoundByIdException("ID was not found.");
//    }

//    @Override
//    public String getImage(Long id) throws NotFoundByIdException {
//        Ingredient ingredient = getIngredientById(id);
//        if (ingredient != null && ingredient.getImage() != null) {
//            byte[] imageBytes = ingredient.getImage();
//            return Base64.getEncoder().encodeToString(imageBytes);
//        }
//        throw new NotFoundByIdException("ID was not found or this ingredient does not have an image.");
//    }


}
