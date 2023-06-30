package com.ulaf.ste.ordering_system.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ListIndexBase;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Boolean customizable;
    private Boolean available;
    private int pizzaNumber;

    @JsonManagedReference
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Ingredient> ingredients;

    @OneToOne
    private Image image;

    public Product(String name, double price,String description,Boolean customizable,Boolean available, List<Ingredient> ingredients, Image image, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
        this.image = image;
        this.description = description;
        this.customizable = customizable;
        this.available = available;
    }
    public Product(String name, double price,String description,Boolean customizable,Boolean available, List<Ingredient> ingredients, Image image, Category category,int pizzaNumber) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
        this.image = image;
        this.description = description;
        this.customizable = customizable;
        this.available = available;
        this.pizzaNumber = pizzaNumber;
    }



    public Product(Long id, String name, Double price, String description, Boolean customizable, Boolean available, Category category, List<Ingredient> ingredients, Image image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.customizable = customizable;
        this.available = available;
        this.category = category;
        this.ingredients = ingredients;
        this.image = image;
    }
}
