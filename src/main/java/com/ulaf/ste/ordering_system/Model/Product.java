package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter@NoArgsConstructor
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
