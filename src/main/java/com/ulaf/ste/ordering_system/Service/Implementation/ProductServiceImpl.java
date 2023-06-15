package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Repository.ProductRepository;
import com.ulaf.ste.ordering_system.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);

        if (existingProduct != null) {
            // Update the existing product with the new values
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            // ...

            // Save the updated product
            return productRepository.save(existingProduct);
        }

        return null; // or throw an exception indicating that the product doesn't exist
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}