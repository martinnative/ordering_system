package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id) throws NotFoundByIdException;
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product) throws NotFoundByIdException;
    Product getProductByName(String name);
    void deleteProduct(Long id);

    Product uploadPizzaImage(Long id, MultipartFile file) throws NotFoundByIdException, IOException;

    String getPizzaImageBase64(Long id) throws NotFoundByIdException;
}
