package com.ulaf.ste.ordering_system.Config;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.*;
import com.ulaf.ste.ordering_system.Repository.ProductQtyRepository;
import com.ulaf.ste.ordering_system.Service.CategoryService;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import com.ulaf.ste.ordering_system.Service.OrderService;
import com.ulaf.ste.ordering_system.Service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final CategoryService categoryService;
    private final IngredientService ingredientService;
    private final ProductService productService;
    private final OrderService orderService;
    private final ProductQtyRepository product_qtyRepository;

    public DataInitializer(CategoryService categoryService, IngredientService ingredientService, ProductService productService, OrderService orderService, ProductQtyRepository productQtyRepository) {
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
        this.productService = productService;
        this.orderService = orderService;
        this.product_qtyRepository = productQtyRepository;
    }

    private byte[] getPizzaImageBytes(String imageName) {
        try {
            ClassPathResource resource = new ClassPathResource("images/" + imageName);
            return StreamUtils.copyToByteArray(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    public void initializeData() throws NotFoundByIdException {
        Category category = categoryService.createCategory(new Category(1L,"Pizza","Kategorija za pizza"));
        Ingredient ingredient1 = ingredientService.createIngredient(new Ingredient("Pechurke"));
        Ingredient ingredient2 = ingredientService.createIngredient(new Ingredient("Sirenje"));

        List<Ingredient> productIngredients = new ArrayList<>();
        productIngredients.add(ingredient1);
        List<Ingredient> productIngredients2 = new ArrayList<>();
        productIngredients2.add(ingredient2);

        byte[] image1 = getPizzaImageBytes("margarita.png");
        byte[] image2 = getPizzaImageBytes("kaprichioza.png");

        productService.createProduct(new Product(1L,"Margarita Pizza", 280.0, productIngredients, image1, category));
        productService.createProduct(new Product(2L,"Kaprichioza Pizza", 320.0, productIngredients2, image2, category));

        List<ProductQty> listItems = new ArrayList<>();
        product_qtyRepository.save(new ProductQty(1L,productService.getProductById(1L), 2));
        product_qtyRepository.save(new ProductQty(2L,productService.getProductById(2L), 3));
        listItems.add(product_qtyRepository.findById(1L).orElseThrow());
        listItems.add(product_qtyRepository.findById(2L).orElseThrow());
        Order order1 = new Order(listItems,"Gorjan","Tetovo","070344899");
        orderService.createOrder(order1);
        categoryService.getCategoryById(1L).setProducts(productService.getAllProducts());

       /* List<ProductQty> listItems2 = new ArrayList<>();
        product_qtyRepository.save(new ProductQty(3L,productService.getProductById(1L), 4));
        product_qtyRepository.save(new ProductQty(4L,productService.getProductById(2L), 2));
        listItems2.add(product_qtyRepository.findById(3L).orElseThrow());
        listItems2.add(product_qtyRepository.findById(4L).orElseThrow());
        Order order2 = new Order(listItems2,"Dragan","Tetovo","071519218");
        orderService.createOrder(order2);*/

    }
}
