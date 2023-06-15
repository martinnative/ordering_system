package com.ulaf.ste.ordering_system.jobs;

import com.ulaf.ste.ordering_system.Model.*;
import com.ulaf.ste.ordering_system.Service.CategoryService;
import com.ulaf.ste.ordering_system.Service.IngredientService;
import com.ulaf.ste.ordering_system.Service.OrderService;
import com.ulaf.ste.ordering_system.Service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {

    private final CategoryService categoryService;
    private final IngredientService ingredientService;
    private final ProductService productService;
    private final OrderService orderService;

    public DataInitializer(CategoryService categoryService, IngredientService ingredientService, ProductService productService, OrderService orderService) {
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @PostConstruct
    public void initializeData() {
        //TODO: generate dummy data to show on frontend
        Category category = categoryService.createCategory(new Category("Pizza","Kategorija za pizza"));
        Ingredient ingredient1 = ingredientService.createIngredient(new Ingredient("Pechurke"));
        Ingredient ingredient2 = ingredientService.createIngredient(new Ingredient("Sirenje"));
        List<Category> productCategories = new ArrayList<>();
        productCategories.add(category);
        List<Ingredient> productIngredients = new ArrayList<>();
        productIngredients.add(ingredient1);
        List<Ingredient> productIngredients2 = new ArrayList<>();
        productIngredients2.add(ingredient2);
        Product product1 = productService.createProduct(new Product(1L,"Margarita Pizza", 280, productCategories, productIngredients));
        Product product2 = productService.createProduct(new Product(2L,"Kaprichioza Pizza", 320, productCategories, productIngredients2));

        List<Product_Qty> listItems = new ArrayList<>();
        listItems.add(new Product_Qty(1L,product1, 2));
        listItems.add(new Product_Qty(2L,product2, 1));
        Order order1 = new Order(1L,listItems,"Gorjan","Tetovo","070344899");
        orderService.createOrder(order1);

        List<Product_Qty> listItems2 = new ArrayList<>();
        listItems2.add(new Product_Qty(3L,product1, 4));
        listItems2.add(new Product_Qty(4L,product2, 2));
        Order order2 = new Order(2L,listItems2,"Dragan","Tetovo","071519218");
        orderService.createOrder(order2);

    }
}
