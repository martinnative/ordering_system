package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Repository.CategoryRepository;
import com.ulaf.ste.ordering_system.Repository.ProductRepository;
import com.ulaf.ste.ordering_system.Service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByCategoryId(Long categoryId) {
        return productRepository.findProductsByCategory(categoryRepository.findCategoryById(categoryId));
    }

    @Override
    public Product getProductById(Long id) throws NotFoundByIdException {
        return productRepository.findById(id).orElseThrow(()->new NotFoundByIdException("ID was not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
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

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProductsWithCategory(String category) throws NotFoundByIdException {
        Category existingCategory = categoryRepository.findCategoryByName(category);
        if(existingCategory!=null)
        {
            return productRepository.findProductsByCategory(existingCategory);
        }
        throw new NotFoundByIdException("Category not found.");
    }
    @Override
    public void addRatingByProductId(Long id, int rating) throws NotFoundByIdException {
        Product product = productRepository.findById(id).orElseThrow(()->new NotFoundByIdException("ID was not found"));
        if (product != null) {
            List<Integer> productRatingsList = product.getRatings();
            productRatingsList.add(rating);
            product.setRatings(productRatingsList);
        }
    }

    @Override
    public Integer findRatingByPId(Long id) throws NotFoundByIdException {
        Product product = productRepository.findById(id).orElseThrow(()->new NotFoundByIdException("ID was not found"));
        if (product != null) {
            return (int) product.calculateAverageRating();
        }
        return 0;
    }



    @Override
    public Product uploadImage(Long id, MultipartFile file) throws NotFoundByIdException, IOException {
        Product product = getProductById(id);
        if (product != null) {
            byte[] imageBytes = file.getBytes();
            product.setImage(imageBytes);
            return productRepository.save(product);
        }
        throw new NotFoundByIdException("ID was not found.");
    }

    @Override
    public String getImage(Long id) throws NotFoundByIdException {
        Product product = getProductById(id);
        if (product != null && product.getImage() != null) {
            byte[] imageBytes = product.getImage();
            return Base64.getEncoder().encodeToString(imageBytes);
        }
        throw new NotFoundByIdException("ID was not found or this pizza does not have an image.");
    }

}
