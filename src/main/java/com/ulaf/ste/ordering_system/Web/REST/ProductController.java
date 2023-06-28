package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws NotFoundByIdException {
        System.out.println(id);
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> findProductsByCategoryId(@PathVariable Long id) {
        List<Product> products = productService.getAllProductsByCategoryId(id);
        return ResponseEntity.ok(products);
    }
    @PostMapping("/{category_name}")
    public ResponseEntity<List<Product>> findAllProductsWithCategory(@PathVariable String category_name) throws NotFoundByIdException {
        List<Product> products = productService.findAllProductsWithCategory(category_name);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) throws NotFoundByIdException {
        Product product = productService.getProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws NotFoundByIdException {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/{id}/upload")
//    public ResponseEntity<Product> uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws NotFoundByIdException, IOException {
//        Product updatedProduct = productService.uploadImage(id, file);
//        if (updatedProduct != null) {
//            return ResponseEntity.ok(updatedProduct);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/{id}/image")
//    public ResponseEntity<String> getImage(@PathVariable Long id) throws NotFoundByIdException {
//        String base64Image = productService.getImage(id);
//        return ResponseEntity.ok(base64Image);
//    }

//    @PostMapping("/{id}/ratings")
//    public void addRating(@PathVariable Long id, @RequestBody int rating) throws NotFoundByIdException {
//        productService.addRatingByProductId(id, rating);
//    }
//
//    @GetMapping("/{id}/ratings")
//    public double findRatingByProductId(@PathVariable Long id) throws NotFoundByIdException {
//        return productService.findRatingByPId(id);
//    }

}
