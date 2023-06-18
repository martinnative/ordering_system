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
    @ManyToMany
    private List<Category> categories;
    @ManyToMany
    private List<Ingredient> ingredients;

    public Product(String name, double price, List<Category> categories, List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.categories = categories;
        this.ingredients = ingredients;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
