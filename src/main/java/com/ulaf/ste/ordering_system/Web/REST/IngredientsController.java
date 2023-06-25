package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Ingredient;
import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {
    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) throws NotFoundByIdException {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        if (ingredient != null) {
            return ResponseEntity.ok(ingredient);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createdIngredient = ingredientService.createIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) throws NotFoundByIdException {
        Ingredient updatedIngredient = ingredientService.updateIngredient(id, ingredient);
        if (updatedIngredient != null) {
            return ResponseEntity.ok(updatedIngredient);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<Ingredient> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws NotFoundByIdException, IOException {
        Ingredient updatedIngredient = ingredientService.uploadImage(id, file);
        if (updatedIngredient != null) {
            return ResponseEntity.ok(updatedIngredient);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<String> getImageBase64(@PathVariable Long id) throws NotFoundByIdException {
        String base64Image = ingredientService.getImageBase64(id);
        return ResponseEntity.ok(base64Image);
    }
}
