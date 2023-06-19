package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Ingredient> ingredients;

    @Lob
    private byte[] pizzaImage;

    public Product(String name, double price, List<Ingredient> ingredients, byte[] pizzaImage, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
        this.pizzaImage = pizzaImage;
    }

    public Product(Long id, String name, double price, List<Ingredient> ingredients, byte[] pizzaImage, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
        this.pizzaImage = pizzaImage;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
