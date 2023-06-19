package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Repository.ProductRepository;
import com.ulaf.ste.ordering_system.Service.ProductService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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
            existingProduct.setCategories(product.getCategories());
            existingProduct.setIngredients(product.getIngredients());
            existingProduct.setPizzaImage(product.getPizzaImage());
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
    public Product uploadPizzaImage(Long id, MultipartFile file) throws NotFoundByIdException, IOException {
        Product product = getProductById(id);
        if (product != null) {
            byte[] imageBytes = file.getBytes();
            product.setPizzaImage(imageBytes);
            return productRepository.save(product);
        }
        throw new NotFoundByIdException("ID was not found.");
    }

    @Override
    public String getPizzaImageBase64(Long id) throws NotFoundByIdException {
        Product product = getProductById(id);
        if (product != null && product.getPizzaImage() != null) {
            byte[] imageBytes = product.getPizzaImage();
            return Base64.getEncoder().encodeToString(imageBytes);
        }
        throw new NotFoundByIdException("ID was not found or this pizza does not have an image.");
    }
}
