package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Model.Ingredient;
import com.ulaf.ste.ordering_system.Service.ImageService;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import com.ulaf.ste.ordering_system.Web.requests.IngredientRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@AllArgsConstructor
public class IngredientsController {
    private final IngredientService ingredientService;
    private final ImageService imageService;

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
    public ResponseEntity<Ingredient> createIngredient(@RequestBody IngredientRequest ingredientRequest) {
        Image image = imageService.findById(ingredientRequest.getImageId());
        Ingredient createdIngredient = new Ingredient(ingredientRequest.getName(),image.getBytes());
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
    public ResponseEntity<String> getImage(@PathVariable Long id) throws NotFoundByIdException {
        String base64Image = ingredientService.getImage(id);
        return ResponseEntity.ok(base64Image);
    }
}
