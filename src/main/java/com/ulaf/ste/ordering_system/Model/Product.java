package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    @OneToMany
    private List<Category> categories;
    @OneToMany
    private List<Ingredient> ingredients;

    public Product(Long id, String name, double price, List<Category> categories, List<Ingredient> ingredients) {
        this.id = id;
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