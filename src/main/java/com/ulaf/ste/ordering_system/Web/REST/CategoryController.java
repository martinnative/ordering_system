package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Service.CategoryService;
import com.ulaf.ste.ordering_system.Service.ImageService;
import com.ulaf.ste.ordering_system.Web.requests.CategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ImageService imageService;

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
    @GetMapping({"/forEveryone"})
    public String forEveryone(){
        return "This URL is only accessible to the forEveryone";
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) throws NotFoundByIdException {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest categoryRequest) {
        Image image = imageService.findById(categoryRequest.getImageId());
        Category category = new Category(categoryRequest.getName(), categoryRequest.getDescription(),image);
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")

    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) throws NotFoundByIdException {
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
