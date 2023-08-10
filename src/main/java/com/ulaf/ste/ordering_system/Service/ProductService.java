package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Repository.CategoryRepository;
import com.ulaf.ste.ordering_system.Repository.ProductRepository;
import com.ulaf.ste.ordering_system.Service.ProductService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().sorted((a,b) -> Boolean.compare(a.getAvailable(),b.getAvailable())).collect(Collectors.toList());
    }

    public List<Product> getAllProductsByCategoryId(Long categoryId) {
        return productRepository.findProductsByCategory(categoryRepository.findCategoryById(categoryId));
    }

    public List<Product> changeProductAvailability(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
        product.setAvailable(!product.getAvailable());
        productRepository.save(product);
        return productRepository.findAll().stream().sorted((a,b) -> Boolean.compare(a.getAvailable(),b.getAvailable())).collect(Collectors.toList());
    }

    public Product getProductById(Long id) throws NotFoundByIdException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundByIdException("ID was not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) throws NotFoundByIdException {
        Product existingProduct = this.getProductById(id);

        if (existingProduct != null) {

            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setIngredients(product.getIngredients());
            existingProduct.setImage(product.getImage());
            return productRepository.save(existingProduct);
        }

        throw new NotFoundByIdException("ID was not found.");
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllProductsWithCategory(String category) throws NotFoundByIdException {
        Category existingCategory = categoryRepository.findCategoryByName(category);
        if (existingCategory != null) {
            return productRepository.findProductsByCategory(existingCategory);
        }
        throw new NotFoundByIdException("Category not found.");
    }

    public Product createProductWithThumbnail(Product prod) throws IOException {
        String image = prod.getImage();
        return new Product(prod.getId(),prod.getName(),prod.getPrice(),prod.getDescription(),prod.getCustomizable(),prod.getAvailable(),prod.getIngredients(),image,prod.getCategory(),prod.getPizzaNumber());
    }

}
