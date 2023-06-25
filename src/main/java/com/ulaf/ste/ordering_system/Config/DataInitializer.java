package com.ulaf.ste.ordering_system.Config;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.*;
import com.ulaf.ste.ordering_system.Repository.OrderItemRepository;
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
    private final OrderItemRepository product_qtyRepository;

    public DataInitializer(CategoryService categoryService, IngredientService ingredientService, ProductService productService, OrderService orderService, OrderItemRepository orderItemRepository) {
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
        this.productService = productService;
        this.orderService = orderService;
        this.product_qtyRepository = orderItemRepository;
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
        Category category = categoryService.createCategory(new Category("Пица","Категорија за пица"));
        Category cat2 = categoryService.createCategory(new Category("Пијалоци","Категорија за пијалоци"));
        Ingredient pecurke = ingredientService.createIngredient(new Ingredient("Pechurke"));
        Ingredient salama = ingredientService.createIngredient(new Ingredient("Salama"));
        Ingredient kaskaval = ingredientService.createIngredient(new Ingredient("Kaskaval"));
        Ingredient kecap = ingredientService.createIngredient(new Ingredient("Kechap"));
        Ingredient kromid = ingredientService.createIngredient(new Ingredient("Kromid"));

        List<Ingredient> productIngredients = new ArrayList<>();
        productIngredients.add(kecap);
        productIngredients.add(kaskaval);
        productIngredients.add(salama);
        productIngredients.add(pecurke);
        productIngredients.add(kromid);
        List<Ingredient> productIngredients2 = new ArrayList<>();
        productIngredients2.add(kaskaval);
        productIngredients2.add(kecap);

        byte[] image1 = getPizzaImageBytes("margarita.png");
        byte[] image2 = getPizzaImageBytes("kaprichioza.png");
        productService.createProduct(new Product("Маргарита", 280.0,"Pizza with cheese and ketchup",true,true, productIngredients2, image1, category));
        productService.createProduct(new Product("Капричиоза", 320.0,"Pizza with ham, cheese and mushrooms",true,true, productIngredients, image2, category));
        productService.createProduct(new Product("Coca Cola",120.0,"Cold drink",false,false,new ArrayList<>(),image1,cat2));

        List<OrderItem> listItems = new ArrayList<>();
        product_qtyRepository.save(new OrderItem(1L,productService.getProductById(1L), 2));
        product_qtyRepository.save(new OrderItem(2L,productService.getProductById(2L), 3));
        listItems.add(product_qtyRepository.findById(1L).orElseThrow());
        listItems.add(product_qtyRepository.findById(2L).orElseThrow());
        Order order1 = new Order(listItems,"Gorjan","Tetovo","070344899");
        orderService.createOrder(order1);
        categoryService.getCategoryById(1L).setProducts(productService.getAllProducts());

       /* List<OrderItem> listItems2 = new ArrayList<>();
        product_qtyRepository.save(new OrderItem(3L,productService.getProductById(1L), 4));
        product_qtyRepository.save(new OrderItem(4L,productService.getProductById(2L), 2));
        listItems2.add(product_qtyRepository.findById(3L).orElseThrow());
        listItems2.add(product_qtyRepository.findById(4L).orElseThrow());
        Order order2 = new Order(listItems2,"Dragan","Tetovo","071519218");
        orderService.createOrder(order2);*/

    }
}
