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
        Category category = new Category("Pizza","Kategorija za pizza");
        categoryService.createCategory(category);

        Ingredient ingredient1 = new Ingredient("Pechurke");
        ingredientService.createIngredient(ingredient1);
        Ingredient ingredient2 = new Ingredient("Sirenje");
        ingredientService.createIngredient(ingredient2);

        List<Category> productCategories = new ArrayList<>();
        productCategories.add(category);
        List<Category> productCategories2 = new ArrayList<>();
        productCategories2.add(category);

        List<Ingredient> productIngredients = new ArrayList<>();
        productIngredients.add(ingredient1);
        List<Ingredient> productIngredients2 = new ArrayList<>();
        productIngredients2.add(ingredient2);

        Product product1 = new Product("Margarita", 280, productCategories, productIngredients);
        productService.createProduct(product1);
        Product product2 = new Product("Kaprichioza", 320, productCategories2, productIngredients2);
        productService.createProduct(product2);

        List<Product_Qty> listItems = new ArrayList<>();
        Product_Qty productQty = new Product_Qty(product1,2);
        listItems.add(productQty);
        Product_Qty productQty2 = new Product_Qty(product2,1);
        listItems.add(productQty2);

        List<Product_Qty> listItems2 = new ArrayList<>();
        Product_Qty productQt3 = new Product_Qty(product1,5);
        listItems2.add(productQt3);
        Product_Qty productQty4 = new Product_Qty(product2,3);
        listItems2.add(productQty4);


        Order order1 = new Order(listItems,"Gorjan","Tetovo","070344899");
        orderService.createOrder(order1);
        Order order2 = new Order(listItems2,"Dragan","Tetovo","071519218");
        orderService.createOrder(order2);

    }
}
