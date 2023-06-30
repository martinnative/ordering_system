package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Model.Product;
import com.ulaf.ste.ordering_system.Repository.CategoryRepository;
import com.ulaf.ste.ordering_system.Repository.ProductRepository;
import com.ulaf.ste.ordering_system.Service.ProductService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        return productRepository.findById(id).orElseThrow(() -> new NotFoundByIdException("ID was not found"));
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
        if (existingCategory != null) {
            return productRepository.findProductsByCategory(existingCategory);
        }
        throw new NotFoundByIdException("Category not found.");
    }

    public Product createProductWithThumbnail(Product prod) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(prod.getImage().getBytes());
        BufferedImage bi = ImageIO.read(bis);
        BufferedImage thumbnail = Thumbnails.of(bi).size(300, 300).asBufferedImage();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(thumbnail, "png", bos);
        byte[] thumbnailBytes = bos.toByteArray();
        Image image = new Image(prod.getImage().getName() + ".thumbnail", thumbnailBytes, "png");
        return new Product(prod.getId(), prod.getName(), prod.getPrice(), prod.getDescription(), prod.getCustomizable(), prod.getAvailable(), prod.getCategory(), prod.getIngredients(), image);
    }

}
