package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id) throws NotFoundByIdException;
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product) throws NotFoundByIdException;
    Product getProductByName(String name);
    void deleteProduct(Long id);
}
