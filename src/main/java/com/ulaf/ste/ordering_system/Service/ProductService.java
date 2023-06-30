package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsByCategoryId(Long categoryId);
    Product getProductById(Long id) throws NotFoundByIdException;
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product) throws NotFoundByIdException;
    Product getProductByName(String name);
    void deleteProduct(Long id);
    Product createProductWithThumbnail(Product product) throws IOException;

//    Product uploadImage(Long id, MultipartFile file) throws NotFoundByIdException, IOException;
//
//    String getImage(Long id) throws NotFoundByIdException;

    List<Product> findAllProductsWithCategory(String category) throws NotFoundByIdException;

//    Integer findRatingByPId(Long id) throws NotFoundByIdException;
//    void addRatingByProductId(Long id, int rating) throws NotFoundByIdException;

}
