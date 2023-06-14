package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Repository.ProductRepository;
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
           return productRepository.findById(id).orElseThrow();
    }

    }
