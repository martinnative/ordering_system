package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
